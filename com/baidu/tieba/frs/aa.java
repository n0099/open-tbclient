package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class aa implements cd {
    final /* synthetic */ FrsActivity bQa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(FrsActivity frsActivity) {
        this.bQa = frsActivity;
    }

    @Override // com.baidu.tieba.frs.cd
    public void a(ce ceVar) {
    }

    @Override // com.baidu.tieba.frs.cd
    public void a(int i, int i2, cl clVar) {
        if (i != 1) {
            com.baidu.tieba.card.cc.TV().cZ(false);
        }
        this.bQa.bOU.abk();
        if (i == 1) {
            this.bQa.bOU.dP(true);
            this.bQa.bOU.dO(false);
        } else {
            this.bQa.bOU.dQ(true);
            this.bQa.bOU.dO(true);
        }
        this.bQa.aaq();
        this.bQa.bPf.a(i, i2, clVar);
    }

    @Override // com.baidu.tieba.frs.cd
    public void init() {
    }

    @Override // com.baidu.tieba.frs.cd
    public void Nx() {
    }
}
