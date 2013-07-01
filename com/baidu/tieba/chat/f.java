package com.baidu.tieba.chat;
/* loaded from: classes.dex */
class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f723a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.f723a = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ChatActivity chatActivity;
        ad adVar;
        chatActivity = this.f723a.f722a;
        adVar = chatActivity.f711a;
        adVar.g();
    }
}
