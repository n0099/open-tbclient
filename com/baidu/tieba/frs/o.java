package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class o implements dl {
    final /* synthetic */ FrsActivity bDB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FrsActivity frsActivity) {
        this.bDB = frsActivity;
    }

    @Override // com.baidu.tieba.frs.dl
    public void a(dm dmVar) {
    }

    @Override // com.baidu.tieba.frs.dl
    public void a(int i, int i2, ds dsVar) {
        bq bqVar;
        bq bqVar2;
        bq bqVar3;
        bq bqVar4;
        bq bqVar5;
        bqVar = this.bDB.bCD;
        bqVar.WD();
        if (i == 1 || i == 2) {
            bqVar2 = this.bDB.bCD;
            bqVar2.dn(true);
            bqVar3 = this.bDB.bCD;
            bqVar3.dl(false);
        } else {
            bqVar4 = this.bDB.bCD;
            bqVar4.m12do(true);
            bqVar5 = this.bDB.bCD;
            bqVar5.dl(true);
        }
        this.bDB.UR();
        this.bDB.bCQ.a(i, i2, dsVar);
    }

    @Override // com.baidu.tieba.frs.dl
    public void init() {
    }

    @Override // com.baidu.tieba.frs.dl
    public void UC() {
    }
}
