package com.baidu.tieba.frs.c;

import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.cn;
/* loaded from: classes.dex */
class r implements Runnable {
    final /* synthetic */ q bpW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.bpW = qVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        o oVar;
        cn cnVar;
        o oVar2;
        FrsActivity frsActivity;
        oVar = this.bpW.bpV;
        cnVar = oVar.bfD;
        if (cnVar.OM()) {
            oVar2 = this.bpW.bpV;
            frsActivity = oVar2.bot;
            frsActivity.OB();
        }
    }
}
