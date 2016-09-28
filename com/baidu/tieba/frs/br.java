package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br implements Runnable {
    final /* synthetic */ bm bRV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(bm bmVar) {
        this.bRV = bmVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.lib.guide.d dVar;
        com.baidu.adp.lib.guide.d dVar2;
        dVar = this.bRV.Hs;
        if (dVar != null) {
            dVar2 = this.bRV.Hs;
            dVar2.dismiss();
        }
    }
}
