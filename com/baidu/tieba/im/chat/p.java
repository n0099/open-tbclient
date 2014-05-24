package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
class p implements Runnable {
    final /* synthetic */ o a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.a = oVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        g gVar;
        gVar = this.a.a;
        gVar.i();
    }
}
