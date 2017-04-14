package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class aa implements cd {
    final /* synthetic */ FrsActivity bNJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(FrsActivity frsActivity) {
        this.bNJ = frsActivity;
    }

    @Override // com.baidu.tieba.frs.cd
    public void a(ce ceVar) {
    }

    @Override // com.baidu.tieba.frs.cd
    public void a(int i, int i2, cl clVar) {
        if (i != 1) {
            com.baidu.tieba.card.cc.ST().cP(false);
        }
        this.bNJ.bMD.aaj();
        if (i == 1) {
            this.bNJ.bMD.dF(true);
            this.bNJ.bMD.dE(false);
        } else {
            this.bNJ.bMD.dG(true);
            this.bNJ.bMD.dE(true);
        }
        this.bNJ.Zp();
        this.bNJ.bMO.a(i, i2, clVar);
    }

    @Override // com.baidu.tieba.frs.cd
    public void init() {
    }

    @Override // com.baidu.tieba.frs.cd
    public void Np() {
    }
}
