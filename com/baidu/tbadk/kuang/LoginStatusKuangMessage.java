package com.baidu.tbadk.kuang;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class LoginStatusKuangMessage extends CustomResponsedMessage<Boolean> {
    public LoginStatusKuangMessage(Boolean bool) {
        super(CmdConfigCustom.CMD_LOGIN_STATUS_KUANG, bool);
    }
}
