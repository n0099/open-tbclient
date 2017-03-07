package com.baidu.tieba.VideoCacheClient;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ f aUZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(f fVar) {
        this.aUZ = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        Runnable runnable;
        z = this.aUZ.aQl;
        if (!z) {
            this.aUZ.JE();
            com.baidu.adp.lib.g.h fM = com.baidu.adp.lib.g.h.fM();
            runnable = this.aUZ.aQn;
            fM.postDelayed(runnable, 1000L);
        }
    }
}
