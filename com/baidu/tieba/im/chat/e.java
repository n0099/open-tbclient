package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.ChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.tieba.im.a<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatMessage f1539a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar, ChatMessage chatMessage) {
        this.b = aVar;
        this.f1539a = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        this.f1539a.setLogTime(System.currentTimeMillis());
        com.baidu.tieba.im.messageCenter.f.a().a(this.f1539a);
        com.baidu.adp.lib.h.d.d("SHANG sendMessage to queue");
    }
}
