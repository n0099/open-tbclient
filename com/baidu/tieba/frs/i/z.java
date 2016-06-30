package com.baidu.tieba.frs.i;

import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements com.baidu.tieba.frs.entelechy.b.f {
    final /* synthetic */ y bSr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.bSr = yVar;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.f
    public void onOpened() {
        this.bSr.onOpened();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.f
    public void onClosed() {
        this.bSr.onClosed();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.f
    public void Yf() {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        this.bSr.bSq = true;
        frsActivity = this.bSr.bJR;
        if (frsActivity.VQ() != null) {
            frsActivity2 = this.bSr.bJR;
            frsActivity2.VQ().dk(false);
            frsActivity3 = this.bSr.bJR;
            frsActivity3.VQ().WM();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.f
    public void Yg() {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        this.bSr.bSq = false;
        frsActivity = this.bSr.bJR;
        if (frsActivity.VQ() != null) {
            frsActivity2 = this.bSr.bJR;
            frsActivity2.VQ().dk(true);
        }
    }
}
