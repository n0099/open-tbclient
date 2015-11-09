package com.baidu.tieba.frs.b;

import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bs;
/* loaded from: classes.dex */
class r implements Runnable {
    final /* synthetic */ q bcL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.bcL = qVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        o oVar;
        bs bsVar;
        o oVar2;
        FrsActivity frsActivity;
        oVar = this.bcL.bcK;
        bsVar = oVar.aUc;
        if (bsVar.KZ()) {
            oVar2 = this.bcL.bcK;
            frsActivity = oVar2.bbk;
            frsActivity.loadMore();
        }
    }
}
