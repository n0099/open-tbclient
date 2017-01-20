package com.baidu.tieba.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ a bub;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.bub = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.lib.guide.d dVar;
        com.baidu.adp.lib.guide.d dVar2;
        dVar = this.bub.GD;
        if (dVar != null) {
            dVar2 = this.bub.GD;
            dVar2.dismiss();
        }
    }
}
