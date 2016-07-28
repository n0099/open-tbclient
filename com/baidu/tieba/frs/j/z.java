package com.baidu.tieba.frs.j;

import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements com.baidu.tieba.frs.entelechy.b.f {
    final /* synthetic */ y bUr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.bUr = yVar;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.f
    public void onOpened() {
        this.bUr.onOpened();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.f
    public void onClosed() {
        this.bUr.onClosed();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.f
    public void Yz() {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        this.bUr.bUq = true;
        frsActivity = this.bUr.bLx;
        if (frsActivity.Wj() != null) {
            frsActivity2 = this.bUr.bLx;
            frsActivity2.Wj().dh(false);
            frsActivity3 = this.bUr.bLx;
            frsActivity3.Wj().Xe();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.f
    public void YA() {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        this.bUr.bUq = false;
        frsActivity = this.bUr.bLx;
        if (frsActivity.Wj() != null) {
            frsActivity2 = this.bUr.bLx;
            frsActivity2.Wj().dh(true);
        }
    }
}
