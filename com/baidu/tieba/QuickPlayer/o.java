package com.baidu.tieba.QuickPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements Runnable {
    final /* synthetic */ m aQE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar) {
        this.aQE = mVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        Runnable runnable;
        z = this.aQE.aQB;
        if (!z) {
            this.aQE.Ke();
            com.baidu.adp.lib.g.h fR = com.baidu.adp.lib.g.h.fR();
            runnable = this.aQE.aQD;
            fR.postDelayed(runnable, 1000L);
        }
    }
}
