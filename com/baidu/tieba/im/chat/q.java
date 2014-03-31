package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
final class q implements Runnable {
    final /* synthetic */ p a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.a = pVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        h hVar;
        hVar = this.a.a;
        hVar.V();
    }
}
