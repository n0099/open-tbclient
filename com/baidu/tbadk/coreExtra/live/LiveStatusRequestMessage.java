package com.baidu.tbadk.coreExtra.live;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class LiveStatusRequestMessage extends CustomResponsedMessage<String> {
    public LiveStatusRequestMessage() {
        super(CmdConfigCustom.CMD_LIVE_STATUS_REQUEST);
    }
}
