package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class l implements eu {
    final /* synthetic */ FrsActivity bed;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(FrsActivity frsActivity) {
        this.bed = frsActivity;
    }

    @Override // com.baidu.tieba.frs.eu
    public void a(ev evVar) {
    }

    @Override // com.baidu.tieba.frs.eu
    public void a(int i, int i2, ex exVar) {
        com.baidu.tieba.frs.b.o oVar;
        com.baidu.tieba.frs.b.o oVar2;
        com.baidu.tieba.frs.b.a aVar;
        com.baidu.tieba.frs.b.o oVar3;
        oVar = this.bed.bdA;
        if (oVar.Qf() != null) {
            oVar2 = this.bed.bdA;
            oVar2.Qf().a(this.bed.bdz.Pt(), this.bed.bdz.Pu(), this.bed.bdz.Pv());
            aVar = this.bed.bdB;
            if (!aVar.PZ()) {
                oVar3 = this.bed.bdA;
                oVar3.Qf().a(i, i2, this.bed.bdz.Pv());
            }
        }
        this.bed.bdm.On();
        if (i == 1) {
            this.bed.bdm.Od();
        } else {
            this.bed.bdm.Oe();
        }
        this.bed.stopVoice();
        this.bed.bdz.a(i, i2, exVar);
    }

    @Override // com.baidu.tieba.frs.eu
    public void init() {
    }

    @Override // com.baidu.tieba.frs.eu
    public void My() {
    }
}
