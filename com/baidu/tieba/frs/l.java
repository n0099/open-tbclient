package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class l implements et {
    final /* synthetic */ FrsActivity bag;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(FrsActivity frsActivity) {
        this.bag = frsActivity;
    }

    @Override // com.baidu.tieba.frs.et
    public void a(eu euVar) {
    }

    @Override // com.baidu.tieba.frs.et
    public void a(int i, int i2, ew ewVar) {
        com.baidu.tieba.frs.b.o oVar;
        com.baidu.tieba.frs.b.o oVar2;
        com.baidu.tieba.frs.b.a aVar;
        com.baidu.tieba.frs.b.o oVar3;
        oVar = this.bag.aZE;
        if (oVar.PN() != null) {
            oVar2 = this.bag.aZE;
            oVar2.PN().a(this.bag.aZD.Pb(), this.bag.aZD.Pc(), this.bag.aZD.Pd());
            aVar = this.bag.aZF;
            if (!aVar.PH()) {
                oVar3 = this.bag.aZE;
                oVar3.PN().a(i, i2, this.bag.aZD.Pd());
            }
        }
        this.bag.aZq.NU();
        if (i == 1) {
            this.bag.aZq.NK();
        } else {
            this.bag.aZq.NL();
        }
        this.bag.stopVoice();
        this.bag.aZD.a(i, i2, ewVar);
    }

    @Override // com.baidu.tieba.frs.et
    public void init() {
    }

    @Override // com.baidu.tieba.frs.et
    public void Mf() {
    }
}
