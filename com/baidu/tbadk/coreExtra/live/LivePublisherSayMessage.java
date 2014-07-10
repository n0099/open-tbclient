package com.baidu.tbadk.coreExtra.live;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class LivePublisherSayMessage extends CustomResponsedMessage<Object> {
    Object chatMsg;

    public LivePublisherSayMessage(Object obj) {
        super(2001170);
        this.chatMsg = obj;
    }

    public Object getChatMsg() {
        return this.chatMsg;
    }
}
