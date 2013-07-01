package com.baidu.tieba.chat;
/* loaded from: classes.dex */
class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f726a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.f726a = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ChatActivity chatActivity;
        ad adVar;
        chatActivity = this.f726a.f725a;
        adVar = chatActivity.f711a;
        adVar.g();
    }
}
