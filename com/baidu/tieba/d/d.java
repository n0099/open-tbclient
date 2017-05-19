package com.baidu.tieba.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ a bDv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.bDv = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.lib.guide.d dVar;
        com.baidu.adp.lib.guide.d dVar2;
        dVar = this.bDv.bDm;
        if (dVar != null) {
            dVar2 = this.bDv.bDm;
            dVar2.dismiss();
        }
    }
}
