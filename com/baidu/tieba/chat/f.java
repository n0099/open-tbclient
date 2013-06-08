package com.baidu.tieba.chat;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.a = eVar;
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
