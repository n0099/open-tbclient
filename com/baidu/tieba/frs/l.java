package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class l implements fe {
    final /* synthetic */ FrsActivity bgz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(FrsActivity frsActivity) {
        this.bgz = frsActivity;
    }

    @Override // com.baidu.tieba.frs.fe
    public void a(ff ffVar) {
    }

    @Override // com.baidu.tieba.frs.fe
    public void a(int i, int i2, fh fhVar) {
        com.baidu.tieba.frs.c.o oVar;
        com.baidu.tieba.frs.c.o oVar2;
        com.baidu.tieba.frs.c.a aVar;
        com.baidu.tieba.frs.c.o oVar3;
        oVar = this.bgz.bfR;
        if (oVar.Sj() != null) {
            oVar2 = this.bgz.bfR;
            oVar2.Sj().a(this.bgz.bfQ.Rx(), this.bgz.bfQ.Ry(), this.bgz.bfQ.Rz());
            aVar = this.bgz.bfS;
            if (!aVar.Sd()) {
                oVar3 = this.bgz.bfR;
                oVar3.Sj().a(i, i2, this.bgz.bfQ.Rz());
            }
        }
        this.bgz.bfD.Qq();
        if (i == 1) {
            this.bgz.bfD.Qd();
        } else {
            this.bgz.bfD.Qe();
        }
        this.bgz.Oy();
        this.bgz.bfQ.a(i, i2, fhVar);
    }

    @Override // com.baidu.tieba.frs.fe
    public void init() {
    }

    @Override // com.baidu.tieba.frs.fe
    public void Op() {
    }
}
