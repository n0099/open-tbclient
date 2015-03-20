package com.baidu.tieba.account.login;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
/* loaded from: classes.dex */
public class Login2ActivityStatic {
    static {
        com.baidu.tbadk.coreExtra.act.a.checkPassV6Switch();
        if (TbadkCoreApplication.m411getInst().getIntentClass(LoginActivityConfig.class) == null || com.baidu.tbadk.coreExtra.act.a.un()) {
            TbadkCoreApplication.m411getInst().RegisterOrUpdateIntent(LoginActivityConfig.class, Login2Activity.class);
        }
    }
}
