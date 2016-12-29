package com.baidu.tieba.VideoCacheClient;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ f aQl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(f fVar) {
        this.aQl = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        Runnable runnable;
        z = this.aQl.aLy;
        if (!z) {
            this.aQl.IM();
            com.baidu.adp.lib.h.h eG = com.baidu.adp.lib.h.h.eG();
            runnable = this.aQl.aLA;
            eG.postDelayed(runnable, 1000L);
        }
    }
}
