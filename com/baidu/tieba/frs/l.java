package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class l implements ea {
    final /* synthetic */ FrsActivity aUK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(FrsActivity frsActivity) {
        this.aUK = frsActivity;
    }

    @Override // com.baidu.tieba.frs.ea
    public void a(eb ebVar) {
    }

    @Override // com.baidu.tieba.frs.ea
    public void a(int i, int i2, ec ecVar) {
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
        oVar = this.aUK.aUj;
        if (oVar.NL() != null) {
            oVar2 = this.aUK.aUj;
            ea NL = oVar2.NL();
            aVar2 = this.aUK.aUi;
            int Nc = aVar2.Nc();
            aVar3 = this.aUK.aUi;
            int Nd = aVar3.Nd();
            aVar4 = this.aUK.aUi;
            NL.a(Nc, Nd, aVar4.Ne());
            aVar5 = this.aUK.aUk;
            if (!aVar5.NF()) {
                oVar3 = this.aUK.aUj;
                ea NL2 = oVar3.NL();
                aVar6 = this.aUK.aUi;
                NL2.a(i, i2, aVar6.Ne());
            }
        }
        if (i == 1) {
            bsVar2 = this.aUK.aTU;
            bsVar2.LT();
        } else {
            bsVar = this.aUK.aTU;
            bsVar.LU();
        }
        this.aUK.stopVoice();
        aVar = this.aUK.aUi;
        aVar.a(i, i2, ecVar);
    }

    @Override // com.baidu.tieba.frs.ea
    public void init() {
    }

    @Override // com.baidu.tieba.frs.ea
    public void Kq() {
    }
}
