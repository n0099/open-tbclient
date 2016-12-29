package com.baidu.tieba.frs.h;

import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements com.baidu.tieba.frs.entelechy.b.f {
    final /* synthetic */ ab bPs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar) {
        this.bPs = abVar;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.f
    public void Zj() {
        this.bPs.Zj();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.f
    public void Zk() {
        this.bPs.Zk();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.f
    public void Zl() {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        this.bPs.bPr = true;
        frsActivity = this.bPs.bFI;
        if (frsActivity.Wo() != null) {
            frsActivity2 = this.bPs.bFI;
            frsActivity2.Wo().du(false);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.f
    public void Zm() {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        this.bPs.bPr = false;
        frsActivity = this.bPs.bFI;
        if (frsActivity.Wo() != null) {
            frsActivity2 = this.bPs.bFI;
            frsActivity2.Wo().du(true);
        }
    }
}
