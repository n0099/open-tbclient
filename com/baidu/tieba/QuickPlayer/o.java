package com.baidu.tieba.QuickPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements Runnable {
    final /* synthetic */ m aQo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar) {
        this.aQo = mVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        Runnable runnable;
        z = this.aQo.aQl;
        if (!z) {
            this.aQo.JE();
            com.baidu.adp.lib.g.h fM = com.baidu.adp.lib.g.h.fM();
            runnable = this.aQo.aQn;
            fM.postDelayed(runnable, 1000L);
        }
    }
}
