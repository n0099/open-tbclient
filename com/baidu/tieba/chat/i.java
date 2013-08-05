package com.baidu.tieba.chat;
/* loaded from: classes.dex */
class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f940a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.f940a = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ChatActivity chatActivity;
        ad adVar;
        chatActivity = this.f940a.f939a;
        adVar = chatActivity.f925a;
        adVar.h();
    }
}
