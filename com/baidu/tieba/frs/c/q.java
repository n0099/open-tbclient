package com.baidu.tieba.frs.c;

import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bl;
/* loaded from: classes.dex */
class q implements Runnable {
    final /* synthetic */ p bbH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.bbH = pVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        n nVar;
        bl blVar;
        n nVar2;
        FrsActivity frsActivity;
        nVar = this.bbH.bbG;
        blVar = nVar.aUw;
        if (blVar.Le()) {
            nVar2 = this.bbH.bbG;
            frsActivity = nVar2.bat;
            frsActivity.loadMore();
        }
    }
}
