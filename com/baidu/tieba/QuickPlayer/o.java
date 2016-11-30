package com.baidu.tieba.QuickPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements Runnable {
    final /* synthetic */ m aMk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar) {
        this.aMk = mVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        Runnable runnable;
        z = this.aMk.aMh;
        if (!z) {
            this.aMk.Jr();
            com.baidu.adp.lib.h.h eG = com.baidu.adp.lib.h.h.eG();
            runnable = this.aMk.aMj;
            eG.postDelayed(runnable, 1000L);
        }
    }
}
