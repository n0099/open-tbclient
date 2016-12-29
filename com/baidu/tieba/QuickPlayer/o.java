package com.baidu.tieba.QuickPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements Runnable {
    final /* synthetic */ m aLB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar) {
        this.aLB = mVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        Runnable runnable;
        z = this.aLB.aLy;
        if (!z) {
            this.aLB.IM();
            com.baidu.adp.lib.h.h eG = com.baidu.adp.lib.h.h.eG();
            runnable = this.aLB.aLA;
            eG.postDelayed(runnable, 1000L);
        }
    }
}
