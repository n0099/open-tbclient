package com.baidu.tieba.frs.g;

import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements com.baidu.tieba.frs.entelechy.b.f {
    final /* synthetic */ ad cec;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ad adVar) {
        this.cec = adVar;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.f
    public void acG() {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        this.cec.acG();
        frsActivity = this.cec.bVk;
        if (frsActivity.aab() != null) {
            frsActivity2 = this.cec.bVk;
            frsActivity2.aab().dN(false);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.f
    public void acH() {
        this.cec.acH();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.f
    public void acI() {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        this.cec.ceb = true;
        frsActivity = this.cec.bVk;
        if (frsActivity.aab() != null) {
            frsActivity2 = this.cec.bVk;
            if (!frsActivity2.isScroll()) {
                frsActivity3 = this.cec.bVk;
                frsActivity3.aab().dN(false);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.f
    public void acJ() {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        this.cec.ceb = false;
        frsActivity = this.cec.bVk;
        if (frsActivity.aab() != null) {
            frsActivity2 = this.cec.bVk;
            frsActivity2.aab().dN(true);
        }
    }
}
