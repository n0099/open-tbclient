package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.ChatMessage;
/* loaded from: classes.dex */
class ba implements com.baidu.tieba.im.model.x {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MsglistActivity f1559a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(MsglistActivity msglistActivity) {
        this.f1559a = msglistActivity;
    }

    @Override // com.baidu.tieba.im.model.x
    public void a(int i, ChatMessage chatMessage) {
        this.f1559a.c.post(new bb(this, i, chatMessage));
    }
}
