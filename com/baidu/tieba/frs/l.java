package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class l implements db {
    final /* synthetic */ FrsActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(FrsActivity frsActivity) {
        this.this$0 = frsActivity;
    }

    @Override // com.baidu.tieba.frs.db
    public void a(dc dcVar) {
    }

    @Override // com.baidu.tieba.frs.db
    public void a(int i, int i2, de deVar) {
        com.baidu.tieba.frs.c.n nVar;
        bl blVar;
        com.baidu.tieba.frs.b.a aVar;
        bl blVar2;
        com.baidu.tieba.frs.c.n nVar2;
        com.baidu.tieba.frs.b.a aVar2;
        com.baidu.tieba.frs.b.a aVar3;
        com.baidu.tieba.frs.b.a aVar4;
        com.baidu.tieba.frs.c.a aVar5;
        com.baidu.tieba.frs.c.n nVar3;
        com.baidu.tieba.frs.b.a aVar6;
        nVar = this.this$0.aUL;
        if (nVar.NO() != null) {
            nVar2 = this.this$0.aUL;
            db NO = nVar2.NO();
            aVar2 = this.this$0.aUK;
            int Ng = aVar2.Ng();
            aVar3 = this.this$0.aUK;
            int Nh = aVar3.Nh();
            aVar4 = this.this$0.aUK;
            NO.a(Ng, Nh, aVar4.Ni());
            aVar5 = this.this$0.aUM;
            if (!aVar5.NI()) {
                nVar3 = this.this$0.aUL;
                db NO2 = nVar3.NO();
                aVar6 = this.this$0.aUK;
                NO2.a(i, i2, aVar6.Ni());
            }
        }
        if (i == 1) {
            blVar2 = this.this$0.aUw;
            blVar2.Mh();
        } else {
            blVar = this.this$0.aUw;
            blVar.Mi();
        }
        this.this$0.stopVoice();
        aVar = this.this$0.aUK;
        aVar.a(i, i2, deVar);
    }

    @Override // com.baidu.tieba.frs.db
    public void init() {
    }

    @Override // com.baidu.tieba.frs.db
    public void KL() {
    }
}
