package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class aa implements cb {
    final /* synthetic */ FrsActivity bNU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(FrsActivity frsActivity) {
        this.bNU = frsActivity;
    }

    @Override // com.baidu.tieba.frs.cb
    public void a(cc ccVar) {
    }

    @Override // com.baidu.tieba.frs.cb
    public void a(int i, int i2, cj cjVar) {
        if (i != 1) {
            com.baidu.tieba.card.cc.Sv().cN(false);
        }
        this.bNU.bMN.ZL();
        if (i == 1 || i == 2) {
            this.bNU.bMN.dD(true);
            this.bNU.bMN.dC(false);
        } else {
            this.bNU.bMN.dE(true);
            this.bNU.bMN.dC(true);
        }
        this.bNU.YT();
        this.bNU.bMY.a(i, i2, cjVar);
    }

    @Override // com.baidu.tieba.frs.cb
    public void init() {
    }

    @Override // com.baidu.tieba.frs.cb
    public void MQ() {
    }
}
