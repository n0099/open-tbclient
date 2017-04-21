package com.baidu.tieba.VideoCacheClient;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ f aVo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(f fVar) {
        this.aVo = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        Runnable runnable;
        z = this.aVo.aQD;
        if (!z) {
            this.aVo.Ke();
            com.baidu.adp.lib.g.h fS = com.baidu.adp.lib.g.h.fS();
            runnable = this.aVo.aQF;
            fS.postDelayed(runnable, 1000L);
        }
    }
}
