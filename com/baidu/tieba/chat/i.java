package com.baidu.tieba.chat;
/* loaded from: classes.dex */
class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f948a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.f948a = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ChatActivity chatActivity;
        ad adVar;
        chatActivity = this.f948a.f947a;
        adVar = chatActivity.f933a;
        adVar.h();
    }
}
