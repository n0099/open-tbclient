package com.baidu.tieba.frs.j;

import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements com.baidu.tieba.frs.entelechy.b.f {
    final /* synthetic */ w ckj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.ckj = wVar;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.f
    public void aeO() {
        this.ckj.aeO();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.f
    public void aeP() {
        this.ckj.aeP();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.f
    public void aeQ() {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        this.ckj.cki = true;
        frsActivity = this.ckj.bZY;
        if (frsActivity.abZ() != null) {
            frsActivity2 = this.ckj.bZY;
            frsActivity2.abZ().dM(false);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.f
    public void aeR() {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        this.ckj.cki = false;
        frsActivity = this.ckj.bZY;
        if (frsActivity.abZ() != null) {
            frsActivity2 = this.ckj.bZY;
            frsActivity2.abZ().dM(true);
        }
    }
}
