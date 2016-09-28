package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class o implements dg {
    final /* synthetic */ FrsActivity bQi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FrsActivity frsActivity) {
        this.bQi = frsActivity;
    }

    @Override // com.baidu.tieba.frs.dg
    public void a(dh dhVar) {
    }

    @Override // com.baidu.tieba.frs.dg
    public void a(int i, int i2, dn dnVar) {
        bm bmVar;
        bm bmVar2;
        bm bmVar3;
        bm bmVar4;
        bm bmVar5;
        if (i != 1) {
            com.baidu.tieba.card.cb.Oj().cs(false);
        }
        bmVar = this.bQi.bPi;
        bmVar.acd();
        if (i == 1 || i == 2) {
            bmVar2 = this.bQi.bPi;
            bmVar2.dJ(true);
            bmVar3 = this.bQi.bPi;
            bmVar3.dH(false);
        } else {
            bmVar4 = this.bQi.bPi;
            bmVar4.dK(true);
            bmVar5 = this.bQi.bPi;
            bmVar5.dH(true);
        }
        this.bQi.abb();
        this.bQi.bPt.a(i, i2, dnVar);
    }

    @Override // com.baidu.tieba.frs.dg
    public void init() {
    }

    @Override // com.baidu.tieba.frs.dg
    public void aat() {
    }
}
