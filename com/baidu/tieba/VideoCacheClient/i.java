package com.baidu.tieba.VideoCacheClient;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ f aVm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(f fVar) {
        this.aVm = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        Runnable runnable;
        z = this.aVm.aQB;
        if (!z) {
            this.aVm.Ke();
            com.baidu.adp.lib.g.h fR = com.baidu.adp.lib.g.h.fR();
            runnable = this.aVm.aQD;
            fR.postDelayed(runnable, 1000L);
        }
    }
}
