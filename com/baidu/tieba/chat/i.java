package com.baidu.tieba.chat;
/* loaded from: classes.dex */
class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f938a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.f938a = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ChatActivity chatActivity;
        ad adVar;
        chatActivity = this.f938a.f937a;
        adVar = chatActivity.f923a;
        adVar.h();
    }
}
