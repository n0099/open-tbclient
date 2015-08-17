package com.baidu.tbadk.coreExtra.live;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class LiveErrorMessage extends CustomResponsedMessage<String> {
    public String errorPrompt;

    public LiveErrorMessage(String str) {
        super(CmdConfigCustom.CMD_LIVE_ERROR, str);
    }
}
