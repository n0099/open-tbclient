package com.baidu.tieba.im.messageCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class q implements Runnable {
    final /* synthetic */ p a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.a = pVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p.a(this.a);
    }
}
