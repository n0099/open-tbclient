package com.baidu.tieba.frs.b;

import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bs;
/* loaded from: classes.dex */
class r implements Runnable {
    final /* synthetic */ q bbV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.bbV = qVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        o oVar;
        bs bsVar;
        o oVar2;
        FrsActivity frsActivity;
        oVar = this.bbV.bbU;
        bsVar = oVar.aTJ;
        if (bsVar.KN()) {
            oVar2 = this.bbV.bbU;
            frsActivity = oVar2.baG;
            frsActivity.loadMore();
        }
    }
}
