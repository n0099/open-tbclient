package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements bx {
    final /* synthetic */ r bPn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(r rVar) {
        this.bPn = rVar;
    }

    @Override // com.baidu.tieba.frs.bx
    public void a(by byVar) {
    }

    @Override // com.baidu.tieba.frs.bx
    public void a(int i, int i2, cd cdVar) {
        if (i != 1) {
            com.baidu.tieba.card.ca.To().dc(false);
        }
        if (i == 1) {
            this.bPn.bOn.dO(true);
            this.bPn.bOn.dN(false);
        } else {
            this.bPn.bOn.dP(true);
            this.bPn.bOn.dN(true);
        }
        this.bPn.Zo();
        this.bPn.bOw.a(i, i2, cdVar);
    }

    @Override // com.baidu.tieba.frs.bx
    public void init() {
    }

    @Override // com.baidu.tieba.frs.bx
    public void ML() {
    }
}
