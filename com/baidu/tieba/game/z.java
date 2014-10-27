package com.baidu.tieba.game;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements Runnable {
    final /* synthetic */ y aHI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.aHI = yVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.lib.guide.d dVar;
        com.baidu.adp.lib.guide.d dVar2;
        dVar = this.aHI.aHF;
        if (dVar != null) {
            dVar2 = this.aHI.aHF;
            dVar2.dismiss();
        }
    }
}
