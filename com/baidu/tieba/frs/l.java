package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class l implements dh {
    final /* synthetic */ FrsActivity aVz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(FrsActivity frsActivity) {
        this.aVz = frsActivity;
    }

    @Override // com.baidu.tieba.frs.dh
    public void a(di diVar) {
    }

    @Override // com.baidu.tieba.frs.dh
    public void a(int i, int i2, dj djVar) {
        com.baidu.tieba.frs.c.n nVar;
        bi biVar;
        com.baidu.tieba.frs.b.a aVar;
        bi biVar2;
        com.baidu.tieba.frs.c.n nVar2;
        com.baidu.tieba.frs.b.a aVar2;
        com.baidu.tieba.frs.b.a aVar3;
        com.baidu.tieba.frs.b.a aVar4;
        com.baidu.tieba.frs.c.a aVar5;
        com.baidu.tieba.frs.c.n nVar3;
        com.baidu.tieba.frs.b.a aVar6;
        nVar = this.aVz.aVa;
        if (nVar.NP() != null) {
            nVar2 = this.aVz.aVa;
            dh NP = nVar2.NP();
            aVar2 = this.aVz.aUZ;
            int Nh = aVar2.Nh();
            aVar3 = this.aVz.aUZ;
            int Ni = aVar3.Ni();
            aVar4 = this.aVz.aUZ;
            NP.a(Nh, Ni, aVar4.Nj());
            aVar5 = this.aVz.aVb;
            if (!aVar5.NJ()) {
                nVar3 = this.aVz.aVa;
                dh NP2 = nVar3.NP();
                aVar6 = this.aVz.aUZ;
                NP2.a(i, i2, aVar6.Nj());
            }
        }
        if (i == 1) {
            biVar2 = this.aVz.aUL;
            biVar2.LY();
        } else {
            biVar = this.aVz.aUL;
            biVar.LZ();
        }
        this.aVz.stopVoice();
        aVar = this.aVz.aUZ;
        aVar.a(i, i2, djVar);
    }

    @Override // com.baidu.tieba.frs.dh
    public void init() {
    }

    @Override // com.baidu.tieba.frs.dh
    public void Kz() {
    }
}
