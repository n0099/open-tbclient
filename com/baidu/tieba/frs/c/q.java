package com.baidu.tieba.frs.c;

import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bi;
/* loaded from: classes.dex */
class q implements Runnable {
    final /* synthetic */ p bcb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.bcb = pVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        n nVar;
        bi biVar;
        n nVar2;
        FrsActivity frsActivity;
        nVar = this.bcb.bca;
        biVar = nVar.aUL;
        if (biVar.KS()) {
            nVar2 = this.bcb.bca;
            frsActivity = nVar2.baN;
            frsActivity.loadMore();
        }
    }
}
