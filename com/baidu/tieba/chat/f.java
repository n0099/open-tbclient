package com.baidu.tieba.chat;
/* loaded from: classes.dex */
class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f937a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.f937a = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ChatActivity chatActivity;
        ad adVar;
        chatActivity = this.f937a.f936a;
        adVar = chatActivity.f925a;
        adVar.h();
    }
}
