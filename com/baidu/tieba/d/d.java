package com.baidu.tieba.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ a bBd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.bBd = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.lib.guide.d dVar;
        com.baidu.adp.lib.guide.d dVar2;
        dVar = this.bBd.bAU;
        if (dVar != null) {
            dVar2 = this.bBd.bAU;
            dVar2.dismiss();
        }
    }
}
