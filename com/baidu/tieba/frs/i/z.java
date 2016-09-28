package com.baidu.tieba.frs.i;

import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements com.baidu.tieba.frs.entelechy.b.f {
    final /* synthetic */ y cfw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.cfw = yVar;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.f
    public void onOpened() {
        this.cfw.onOpened();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.f
    public void onClosed() {
        this.cfw.onClosed();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.f
    public void adz() {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        this.cfw.cfv = true;
        frsActivity = this.cfw.bWH;
        if (frsActivity.abs() != null) {
            frsActivity2 = this.cfw.bWH;
            frsActivity2.abs().dG(false);
            frsActivity3 = this.cfw.bWH;
            frsActivity3.abs().aco();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.f
    public void adA() {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        this.cfw.cfv = false;
        frsActivity = this.cfw.bWH;
        if (frsActivity.abs() != null) {
            frsActivity2 = this.cfw.bWH;
            frsActivity2.abs().dG(true);
        }
    }
}
