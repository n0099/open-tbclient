package com.baidu.tieba.VideoCacheClient;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ f aPn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(f fVar) {
        this.aPn = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        Runnable runnable;
        z = this.aPn.aKA;
        if (!z) {
            this.aPn.IZ();
            com.baidu.adp.lib.g.h eE = com.baidu.adp.lib.g.h.eE();
            runnable = this.aPn.aKC;
            eE.postDelayed(runnable, 1000L);
        }
    }
}
