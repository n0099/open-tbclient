package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class l implements ec {
    final /* synthetic */ FrsActivity aUS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(FrsActivity frsActivity) {
        this.aUS = frsActivity;
    }

    @Override // com.baidu.tieba.frs.ec
    public void a(ed edVar) {
    }

    @Override // com.baidu.tieba.frs.ec
    public void a(int i, int i2, ee eeVar) {
        com.baidu.tieba.frs.b.o oVar;
        bs bsVar;
        com.baidu.tieba.frs.mc.a aVar;
        bs bsVar2;
        com.baidu.tieba.frs.b.o oVar2;
        com.baidu.tieba.frs.mc.a aVar2;
        com.baidu.tieba.frs.mc.a aVar3;
        com.baidu.tieba.frs.mc.a aVar4;
        com.baidu.tieba.frs.b.a aVar5;
        com.baidu.tieba.frs.b.o oVar3;
        com.baidu.tieba.frs.mc.a aVar6;
        oVar = this.aUS.aUr;
        if (oVar.Oh() != null) {
            oVar2 = this.aUS.aUr;
            ec Oh = oVar2.Oh();
            aVar2 = this.aUS.aUq;
            int Nv = aVar2.Nv();
            aVar3 = this.aUS.aUq;
            int Nw = aVar3.Nw();
            aVar4 = this.aUS.aUq;
            Oh.a(Nv, Nw, aVar4.Nx());
            aVar5 = this.aUS.aUs;
            if (!aVar5.Ob()) {
                oVar3 = this.aUS.aUr;
                ec Oh2 = oVar3.Oh();
                aVar6 = this.aUS.aUq;
                Oh2.a(i, i2, aVar6.Nx());
            }
        }
        if (i == 1) {
            bsVar2 = this.aUS.aUc;
            bsVar2.Mj();
        } else {
            bsVar = this.aUS.aUc;
            bsVar.Mk();
        }
        this.aUS.stopVoice();
        aVar = this.aUS.aUq;
        aVar.a(i, i2, eeVar);
    }

    @Override // com.baidu.tieba.frs.ec
    public void init() {
    }

    @Override // com.baidu.tieba.frs.ec
    public void KG() {
    }
}
