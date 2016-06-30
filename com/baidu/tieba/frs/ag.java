package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class ag implements Runnable {
    final /* synthetic */ af bDF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(af afVar) {
        this.bDF = afVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        FrsActivity frsActivity;
        bq bqVar;
        FrsActivity frsActivity2;
        frsActivity = this.bDF.bDB;
        bqVar = frsActivity.bCD;
        if (bqVar.Vf()) {
            frsActivity2 = this.bDF.bDB;
            frsActivity2.UU();
        }
    }
}
