package com.baidu.tieba.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ a bJl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.bJl = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.lib.guide.d dVar;
        com.baidu.adp.lib.guide.d dVar2;
        dVar = this.bJl.bJc;
        if (dVar != null) {
            dVar2 = this.bJl.bJc;
            dVar2.dismiss();
        }
    }
}
