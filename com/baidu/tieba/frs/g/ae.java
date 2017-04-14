package com.baidu.tieba.frs.g;

import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements com.baidu.tieba.frs.entelechy.b.f {
    final /* synthetic */ ad cbL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ad adVar) {
        this.cbL = adVar;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.f
    public void abF() {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        this.cbL.abF();
        frsActivity = this.cbL.bST;
        if (frsActivity.Za() != null) {
            frsActivity2 = this.cbL.bST;
            frsActivity2.Za().dD(false);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.f
    public void abG() {
        this.cbL.abG();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.f
    public void abH() {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        this.cbL.cbK = true;
        frsActivity = this.cbL.bST;
        if (frsActivity.Za() != null) {
            frsActivity2 = this.cbL.bST;
            if (!frsActivity2.isScroll()) {
                frsActivity3 = this.cbL.bST;
                frsActivity3.Za().dD(false);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.f
    public void abI() {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        this.cbL.cbK = false;
        frsActivity = this.cbL.bST;
        if (frsActivity.Za() != null) {
            frsActivity2 = this.cbL.bST;
            frsActivity2.Za().dD(true);
        }
    }
}
