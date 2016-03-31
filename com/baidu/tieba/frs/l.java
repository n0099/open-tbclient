package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class l implements fo {
    final /* synthetic */ FrsActivity blk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(FrsActivity frsActivity) {
        this.blk = frsActivity;
    }

    @Override // com.baidu.tieba.frs.fo
    public void a(fp fpVar) {
    }

    @Override // com.baidu.tieba.frs.fo
    public void a(int i, int i2, fq fqVar) {
        com.baidu.tieba.frs.c.o oVar;
        com.baidu.tieba.frs.c.o oVar2;
        com.baidu.tieba.frs.c.a aVar;
        com.baidu.tieba.frs.c.o oVar3;
        oVar = this.blk.bkC;
        if (oVar.TY() != null) {
            oVar2 = this.blk.bkC;
            oVar2.TY().a(this.blk.bkB.Tk(), this.blk.bkB.Tl(), this.blk.bkB.Tm());
            aVar = this.blk.bkD;
            if (!aVar.TR()) {
                oVar3 = this.blk.bkC;
                oVar3.TY().a(i, i2, this.blk.bkB.Tm());
            }
        }
        this.blk.bko.Sj();
        if (i == 1) {
            this.blk.bko.RW();
        } else {
            this.blk.bko.RX();
        }
        this.blk.Qn();
        this.blk.bkB.a(i, i2, fqVar);
    }

    @Override // com.baidu.tieba.frs.fo
    public void init() {
    }

    @Override // com.baidu.tieba.frs.fo
    public void Qe() {
    }
}
