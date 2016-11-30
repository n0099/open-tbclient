package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class x implements ce {
    final /* synthetic */ FrsActivity bTa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(FrsActivity frsActivity) {
        this.bTa = frsActivity;
    }

    @Override // com.baidu.tieba.frs.ce
    public void a(cf cfVar) {
    }

    @Override // com.baidu.tieba.frs.ce
    public void a(int i, int i2, cm cmVar) {
        if (i != 1) {
            com.baidu.tieba.card.bx.Pl().cx(false);
        }
        this.bTa.bRW.adk();
        if (i == 1 || i == 2) {
            this.bTa.bRW.dP(true);
            this.bTa.bRW.dN(false);
        } else {
            this.bTa.bRW.dQ(true);
            this.bTa.bRW.dN(true);
        }
        this.bTa.acp();
        this.bTa.bSh.a(i, i2, cmVar);
    }

    @Override // com.baidu.tieba.frs.ce
    public void init() {
    }

    @Override // com.baidu.tieba.frs.ce
    public void abv() {
    }
}
