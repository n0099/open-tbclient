package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ a bxN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.bxN = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.lib.guide.d dVar;
        com.baidu.adp.lib.guide.d dVar2;
        dVar = this.bxN.Ht;
        if (dVar != null) {
            dVar2 = this.bxN.Ht;
            dVar2.dismiss();
        }
    }
}
