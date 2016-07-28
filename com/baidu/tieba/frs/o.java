package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class o implements dl {
    final /* synthetic */ FrsActivity bEL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FrsActivity frsActivity) {
        this.bEL = frsActivity;
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
        if (i != 1) {
            com.baidu.tieba.card.bw.Lf().cm(false);
        }
        bqVar = this.bEL.bDK;
        bqVar.WU();
        if (i == 1 || i == 2) {
            bqVar2 = this.bEL.bDK;
            bqVar2.dk(true);
            bqVar3 = this.bEL.bDK;
            bqVar3.di(false);
        } else {
            bqVar4 = this.bEL.bDK;
            bqVar4.dl(true);
            bqVar5 = this.bEL.bDK;
            bqVar5.di(true);
        }
        this.bEL.VR();
        this.bEL.bDX.a(i, i2, dsVar);
    }

    @Override // com.baidu.tieba.frs.dl
    public void init() {
    }

    @Override // com.baidu.tieba.frs.dl
    public void Vk() {
    }
}
