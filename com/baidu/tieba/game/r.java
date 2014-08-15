package com.baidu.tieba.game;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements Runnable {
    final /* synthetic */ n a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(n nVar) {
        this.a = nVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.lib.guide.d dVar;
        com.baidu.adp.lib.guide.d dVar2;
        dVar = this.a.v;
        if (dVar != null) {
            dVar2 = this.a.v;
            dVar2.a();
        }
    }
}
