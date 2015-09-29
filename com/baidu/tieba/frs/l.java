package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class l implements ea {
    final /* synthetic */ FrsActivity aUz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(FrsActivity frsActivity) {
        this.aUz = frsActivity;
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
        oVar = this.aUz.aTY;
        if (oVar.NP() != null) {
            oVar2 = this.aUz.aTY;
            ea NP = oVar2.NP();
            aVar2 = this.aUz.aTX;
            int Ng = aVar2.Ng();
            aVar3 = this.aUz.aTX;
            int Nh = aVar3.Nh();
            aVar4 = this.aUz.aTX;
            NP.a(Ng, Nh, aVar4.Ni());
            aVar5 = this.aUz.aTZ;
            if (!aVar5.NJ()) {
                oVar3 = this.aUz.aTY;
                ea NP2 = oVar3.NP();
                aVar6 = this.aUz.aTX;
                NP2.a(i, i2, aVar6.Ni());
            }
        }
        if (i == 1) {
            bsVar2 = this.aUz.aTJ;
            bsVar2.LX();
        } else {
            bsVar = this.aUz.aTJ;
            bsVar.LY();
        }
        this.aUz.stopVoice();
        aVar = this.aUz.aTX;
        aVar.a(i, i2, ecVar);
    }

    @Override // com.baidu.tieba.frs.ea
    public void init() {
    }

    @Override // com.baidu.tieba.frs.ea
    public void Ku() {
    }
}
