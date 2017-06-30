package com.baidu.tieba.QuickPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements Runnable {
    final /* synthetic */ m aSt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar) {
        this.aSt = mVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        Runnable runnable;
        z = this.aSt.aSq;
        if (!z) {
            this.aSt.JN();
            com.baidu.adp.lib.g.h fR = com.baidu.adp.lib.g.h.fR();
            runnable = this.aSt.aSs;
            fR.postDelayed(runnable, 1000L);
        }
    }
}
