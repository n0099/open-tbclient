package com.baidu.tbadk.coreExtra.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class ShareSDKResultMessage extends CustomResponsedMessage<Boolean> {
    public ShareSDKResultMessage(Boolean bool) {
        super(CmdConfigCustom.CMD_SHARE_SDK_RESULT, bool);
    }
}
