package com.baidu.tieba.QuickPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements Runnable {
    final /* synthetic */ m aRa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar) {
        this.aRa = mVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        Runnable runnable;
        z = this.aRa.aQX;
        if (!z) {
            this.aRa.Jp();
            com.baidu.adp.lib.g.h fS = com.baidu.adp.lib.g.h.fS();
            runnable = this.aRa.aQZ;
            fS.postDelayed(runnable, 1000L);
        }
    }
}
