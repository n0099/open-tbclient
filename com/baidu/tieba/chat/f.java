package com.baidu.tieba.chat;
/* loaded from: classes.dex */
class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f962a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.f962a = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ChatActivity chatActivity;
        ac acVar;
        chatActivity = this.f962a.f961a;
        acVar = chatActivity.f951a;
        acVar.h();
    }
}
