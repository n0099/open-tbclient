package com.baidu.tieba.game.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    final /* synthetic */ b aKp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.aKp = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.lib.guide.d dVar;
        com.baidu.adp.lib.guide.d dVar2;
        dVar = this.aKp.aHP;
        if (dVar != null) {
            dVar2 = this.aKp.aHP;
            dVar2.dismiss();
        }
    }
}
