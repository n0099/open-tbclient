package com.baidu.tieba.frs.b;

import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bs;
/* loaded from: classes.dex */
class r implements Runnable {
    final /* synthetic */ q bcg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.bcg = qVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        o oVar;
        bs bsVar;
        o oVar2;
        FrsActivity frsActivity;
        oVar = this.bcg.bcf;
        bsVar = oVar.aTU;
        if (bsVar.KJ()) {
            oVar2 = this.bcg.bcf;
            frsActivity = oVar2.baR;
            frsActivity.loadMore();
        }
    }
}
