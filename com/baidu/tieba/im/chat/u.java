package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
class u implements Runnable {
    final /* synthetic */ t a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.a = tVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        h hVar;
        hVar = this.a.a;
        hVar.V();
    }
}
