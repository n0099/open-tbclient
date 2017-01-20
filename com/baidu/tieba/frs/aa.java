package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class aa implements cb {
    final /* synthetic */ FrsActivity bGL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(FrsActivity frsActivity) {
        this.bGL = frsActivity;
    }

    @Override // com.baidu.tieba.frs.cb
    public void a(cc ccVar) {
    }

    @Override // com.baidu.tieba.frs.cb
    public void a(int i, int i2, cj cjVar) {
        if (i != 1) {
            com.baidu.tieba.card.cc.Rx().cN(false);
        }
        this.bGL.bFF.YM();
        if (i == 1 || i == 2) {
            this.bGL.bFF.dD(true);
            this.bGL.bFF.dC(false);
        } else {
            this.bGL.bFF.dE(true);
            this.bGL.bFF.dC(true);
        }
        this.bGL.XU();
        this.bGL.bFQ.a(i, i2, cjVar);
    }

    @Override // com.baidu.tieba.frs.cb
    public void init() {
    }

    @Override // com.baidu.tieba.frs.cb
    public void Me() {
    }
}
