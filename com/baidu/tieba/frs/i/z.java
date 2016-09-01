package com.baidu.tieba.frs.i;

import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements com.baidu.tieba.frs.entelechy.b.f {
    final /* synthetic */ y cfz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.cfz = yVar;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.f
    public void onOpened() {
        this.cfz.onOpened();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.f
    public void onClosed() {
        this.cfz.onClosed();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.f
    public void adl() {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        this.cfz.cfy = true;
        frsActivity = this.cfz.bWH;
        if (frsActivity.abg() != null) {
            frsActivity2 = this.cfz.bWH;
            frsActivity2.abg().dF(false);
            frsActivity3 = this.cfz.bWH;
            frsActivity3.abg().acb();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.f
    public void adm() {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        this.cfz.cfy = false;
        frsActivity = this.cfz.bWH;
        if (frsActivity.abg() != null) {
            frsActivity2 = this.cfz.bWH;
            frsActivity2.abg().dF(true);
        }
    }
}
