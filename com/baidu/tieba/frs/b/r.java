package com.baidu.tieba.frs.b;

import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.cg;
/* loaded from: classes.dex */
class r implements Runnable {
    final /* synthetic */ q bnh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.bnh = qVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        o oVar;
        cg cgVar;
        o oVar2;
        FrsActivity frsActivity;
        oVar = this.bnh.bng;
        cgVar = oVar.bdm;
        if (cgVar.MR()) {
            oVar2 = this.bnh.bng;
            frsActivity = oVar2.blE;
            frsActivity.loadMore();
        }
    }
}
