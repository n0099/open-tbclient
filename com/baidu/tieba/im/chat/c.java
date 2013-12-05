package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.ChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tieba.im.a<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatMessage f1585a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, ChatMessage chatMessage) {
        this.b = aVar;
        this.f1585a = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        this.f1585a.setLogTime(System.currentTimeMillis());
        com.baidu.tieba.im.messageCenter.e.a().a(this.f1585a);
        com.baidu.adp.lib.h.e.d("SHANG sendMessage to queue");
    }
}
