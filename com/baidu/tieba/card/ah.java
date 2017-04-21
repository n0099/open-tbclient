package com.baidu.tieba.card;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements Runnable {
    final /* synthetic */ x bvq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(x xVar) {
        this.bvq = xVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bvq.f(true, 4);
    }
}
