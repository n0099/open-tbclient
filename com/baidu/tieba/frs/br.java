package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br implements Runnable {
    final /* synthetic */ bm bSc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(bm bmVar) {
        this.bSc = bmVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.lib.guide.d dVar;
        com.baidu.adp.lib.guide.d dVar2;
        dVar = this.bSc.Hs;
        if (dVar != null) {
            dVar2 = this.bSc.Hs;
            dVar2.dismiss();
        }
    }
}
