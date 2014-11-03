package com.baidu.tieba.game;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements Runnable {
    final /* synthetic */ y aHS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.aHS = yVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.lib.guide.d dVar;
        com.baidu.adp.lib.guide.d dVar2;
        dVar = this.aHS.aHP;
        if (dVar != null) {
            dVar2 = this.aHS.aHP;
            dVar2.dismiss();
        }
    }
}
