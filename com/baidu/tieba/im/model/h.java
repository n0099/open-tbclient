package com.baidu.tieba.im.model;

import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.tieba.im.message.RequestEnterChatRoomMessage;
/* loaded from: classes.dex */
public class h extends com.baidu.adp.base.e {
    private int a;
    private RequestEnterChatRoomMessage b;

    public int a() {
        return this.a;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    private RequestEnterChatRoomMessage b(long j, boolean z) {
        RequestEnterChatRoomMessage requestEnterChatRoomMessage = new RequestEnterChatRoomMessage(z);
        requestEnterChatRoomMessage.setLastGroupId(j);
        return requestEnterChatRoomMessage;
    }

    public void a(long j, boolean z) {
        this.b = b(j, z);
        super.sendMessage(this.b);
    }

    public void b() {
    }

    @Override // com.baidu.adp.base.e
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(106101, messageListener);
    }
}
