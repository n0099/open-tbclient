package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class n implements fg {
    final /* synthetic */ FrsActivity bhl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(FrsActivity frsActivity) {
        this.bhl = frsActivity;
    }

    @Override // com.baidu.tieba.frs.fg
    public void a(fi fiVar) {
    }

    @Override // com.baidu.tieba.frs.fg
    public void a(int i, int i2, fo foVar) {
        cn cnVar;
        cn cnVar2;
        cn cnVar3;
        cn cnVar4;
        cn cnVar5;
        cnVar = this.bhl.bgo;
        cnVar.Rj();
        if (i == 1 || i == 2) {
            cnVar2 = this.bhl.bgo;
            cnVar2.cS(true);
            cnVar3 = this.bhl.bgo;
            cnVar3.cP(false);
        } else {
            cnVar4 = this.bhl.bgo;
            cnVar4.cT(true);
            cnVar5 = this.bhl.bgo;
            cnVar5.cP(true);
        }
        this.bhl.Pk();
        this.bhl.bgC.a(i, i2, foVar);
    }

    @Override // com.baidu.tieba.frs.fg
    public void init() {
    }

    @Override // com.baidu.tieba.frs.fg
    public void OY() {
    }
}
