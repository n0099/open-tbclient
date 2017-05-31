package com.baidu.tieba.VideoCacheClient;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class i implements Runnable {
    final /* synthetic */ f aTk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(f fVar) {
        this.aTk = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        Runnable runnable;
        z = this.aTk.aQX;
        if (!z) {
            this.aTk.Jp();
            com.baidu.adp.lib.g.h fS = com.baidu.adp.lib.g.h.fS();
            runnable = this.aTk.aQZ;
            fS.postDelayed(runnable, 1000L);
        }
    }
}
