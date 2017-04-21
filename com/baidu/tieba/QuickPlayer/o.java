package com.baidu.tieba.QuickPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements Runnable {
    final /* synthetic */ m aQG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar) {
        this.aQG = mVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        Runnable runnable;
        z = this.aQG.aQD;
        if (!z) {
            this.aQG.Ke();
            com.baidu.adp.lib.g.h fS = com.baidu.adp.lib.g.h.fS();
            runnable = this.aQG.aQF;
            fS.postDelayed(runnable, 1000L);
        }
    }
}
