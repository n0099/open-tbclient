package com.baidu.tbadk.coreExtra.live;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
/* loaded from: classes.dex */
public class LiveStatusRequestMessage extends CustomResponsedMessage<String> {
    public LiveStatusRequestMessage() {
        super(MessageTypes.CMD_LIVE_STATUS_REQUEST);
    }
}
