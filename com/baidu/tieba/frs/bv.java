package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv implements Runnable {
    final /* synthetic */ bq bFI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(bq bqVar) {
        this.bFI = bqVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.lib.guide.d dVar;
        com.baidu.adp.lib.guide.d dVar2;
        dVar = this.bFI.EF;
        if (dVar != null) {
            dVar2 = this.bFI.EF;
            dVar2.dismiss();
        }
    }
}
