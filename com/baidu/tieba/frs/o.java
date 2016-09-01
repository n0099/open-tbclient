package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class o implements dg {
    final /* synthetic */ FrsActivity bQp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FrsActivity frsActivity) {
        this.bQp = frsActivity;
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
            com.baidu.tieba.card.cd.NI().cs(false);
        }
        bmVar = this.bQp.bPo;
        bmVar.abQ();
        if (i == 1 || i == 2) {
            bmVar2 = this.bQp.bPo;
            bmVar2.dI(true);
            bmVar3 = this.bQp.bPo;
            bmVar3.dG(false);
        } else {
            bmVar4 = this.bQp.bPo;
            bmVar4.dJ(true);
            bmVar5 = this.bQp.bPo;
            bmVar5.dG(true);
        }
        this.bQp.aaO();
        this.bQp.bPB.a(i, i2, dnVar);
    }

    @Override // com.baidu.tieba.frs.dg
    public void init() {
    }

    @Override // com.baidu.tieba.frs.dg
    public void aaf() {
    }
}
