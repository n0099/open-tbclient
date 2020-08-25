package com.baidu.tbadk.coreExtra.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes2.dex */
public class ShareSDKResultMessage extends CustomResponsedMessage<Boolean> {
    public ShareSDKResultMessage(Boolean bool) {
        super(CmdConfigCustom.CMD_SHARE_SDK_RESULT, bool);
    }
}
