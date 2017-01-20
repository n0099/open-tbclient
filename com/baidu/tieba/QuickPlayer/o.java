package com.baidu.tieba.QuickPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements Runnable {
    final /* synthetic */ m aKD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar) {
        this.aKD = mVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        Runnable runnable;
        z = this.aKD.aKA;
        if (!z) {
            this.aKD.IZ();
            com.baidu.adp.lib.g.h eE = com.baidu.adp.lib.g.h.eE();
            runnable = this.aKD.aKC;
            eE.postDelayed(runnable, 1000L);
        }
    }
}
