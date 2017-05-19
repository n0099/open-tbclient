package com.baidu.tieba.QuickPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements Runnable {
    final /* synthetic */ m aQZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar) {
        this.aQZ = mVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        Runnable runnable;
        z = this.aQZ.aQW;
        if (!z) {
            this.aQZ.Js();
            com.baidu.adp.lib.g.h fS = com.baidu.adp.lib.g.h.fS();
            runnable = this.aQZ.aQY;
            fS.postDelayed(runnable, 1000L);
        }
    }
}
