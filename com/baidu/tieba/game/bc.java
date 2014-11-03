package com.baidu.tieba.game;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc implements Runnable {
    final /* synthetic */ av aJj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(av avVar) {
        this.aJj = avVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.lib.guide.d dVar;
        com.baidu.adp.lib.guide.d dVar2;
        dVar = this.aJj.aHP;
        if (dVar != null) {
            dVar2 = this.aJj.aHP;
            dVar2.dismiss();
        }
    }
}
