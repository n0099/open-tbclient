package com.baidu.tieba.VideoCacheClient;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ f aQU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(f fVar) {
        this.aQU = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        Runnable runnable;
        z = this.aQU.aMh;
        if (!z) {
            this.aQU.Jr();
            com.baidu.adp.lib.h.h eG = com.baidu.adp.lib.h.h.eG();
            runnable = this.aQU.aMj;
            eG.postDelayed(runnable, 1000L);
        }
    }
}
