package com.baidu.tbadk.coreExtra.live;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
/* loaded from: classes.dex */
public class LivePublisherSayMessage extends CustomResponsedMessage<Object> {
    Object chatMsg;

    public LivePublisherSayMessage(Object obj) {
        super(MessageTypes.CMD_LIVE_PUBLISH_SAY);
        this.chatMsg = obj;
    }

    public Object getChatMsg() {
        return this.chatMsg;
    }
}
