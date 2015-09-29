package com.baidu.tbadk.coreExtra.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class UninstallInquirerBySwitchMessage extends CustomResponsedMessage<Integer> {
    public UninstallInquirerBySwitchMessage() {
        super(CmdConfigCustom.CMD_UNINSTALL_BY_SWITCH);
    }
}
