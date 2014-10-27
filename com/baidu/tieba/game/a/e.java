package com.baidu.tieba.game.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    final /* synthetic */ b aKb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.aKb = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.lib.guide.d dVar;
        com.baidu.adp.lib.guide.d dVar2;
        dVar = this.aKb.aHF;
        if (dVar != null) {
            dVar2 = this.aKb.aHF;
            dVar2.dismiss();
        }
    }
}
