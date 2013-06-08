package com.baidu.tieba.chat;
/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ h a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.a = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ChatActivity chatActivity;
        ad adVar;
        chatActivity = this.a.a;
        adVar = chatActivity.c;
        adVar.g();
    }
}
