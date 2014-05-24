package com.baidu.tieba.im.model;

import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tieba.im.message.RequestEnterChatRoomMessage;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.base.b {
    private int a;
    private RequestEnterChatRoomMessage b;

    public int a() {
        return this.a;
    }

    @Override // com.baidu.adp.base.b
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.b
    public boolean cancelLoadData() {
        return false;
    }

    private RequestEnterChatRoomMessage b(long j) {
        RequestEnterChatRoomMessage requestEnterChatRoomMessage = new RequestEnterChatRoomMessage();
        requestEnterChatRoomMessage.setLastGroupId(j);
        return requestEnterChatRoomMessage;
    }

    public void a(long j) {
        this.b = b(j);
        super.sendMessage(this.b);
    }

    public void b() {
    }

    @Override // com.baidu.adp.base.b
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(MessageTypes.CMD_REQUEST_ENTER_CHAT_ROOM, messageListener);
    }
}
