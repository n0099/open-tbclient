package com.baidu.tieba.VideoCacheClient;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class i implements Runnable {
    final /* synthetic */ f aVI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(f fVar) {
        this.aVI = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        Runnable runnable;
        z = this.aVI.aQW;
        if (!z) {
            this.aVI.Js();
            com.baidu.adp.lib.g.h fS = com.baidu.adp.lib.g.h.fS();
            runnable = this.aVI.aQY;
            fS.postDelayed(runnable, 1000L);
        }
    }
}
