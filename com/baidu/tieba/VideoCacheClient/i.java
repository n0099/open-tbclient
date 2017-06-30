package com.baidu.tieba.VideoCacheClient;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class i implements Runnable {
    final /* synthetic */ f aUD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(f fVar) {
        this.aUD = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        Runnable runnable;
        z = this.aUD.aSq;
        if (!z) {
            this.aUD.JN();
            com.baidu.adp.lib.g.h fR = com.baidu.adp.lib.g.h.fR();
            runnable = this.aUD.aSs;
            fR.postDelayed(runnable, 1000L);
        }
    }
}
