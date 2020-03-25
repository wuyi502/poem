package poem.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import poem.service.UserService;
import pojo.UserForm;

@Controller
@RequestMapping("/user")
public class UserController {
	private static final Log logger = LogFactory.getLog(UserController.class);
	
	@Autowired
	UserService userService;

	/**
	 * 处理注册
	 */
	@RequestMapping("/register")
	public String register(@ModelAttribute("user") UserForm user) {
		if(userService.register(user)) {
//			System.out.println("注册成功！");
			logger.info("注册成功");
			return "login";   ////注册成功，跳转到login.jsp
		}else {
			logger.info("注册失败");
			return "register";  //返回register.jsp
		}
	}
}
