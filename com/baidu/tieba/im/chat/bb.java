package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.ChatMessage;
/* loaded from: classes.dex */
class bb implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f1560a;
    final /* synthetic */ ChatMessage b;
    final /* synthetic */ ba c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(ba baVar, int i, ChatMessage chatMessage) {
        this.c = baVar;
        this.f1560a = i;
        this.b = chatMessage;
    }

    @Override // java.lang.Runnable
    public void run() {
        bm bmVar;
        bmVar = this.c.f1559a.f;
        bmVar.a(this.f1560a, this.b);
    }
}
