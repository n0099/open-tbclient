package com.baidu.tieba.frs.b;

import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.cd;
/* loaded from: classes.dex */
class r implements Runnable {
    final /* synthetic */ q bjq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.bjq = qVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        o oVar;
        cd cdVar;
        o oVar2;
        FrsActivity frsActivity;
        oVar = this.bjq.bjp;
        cdVar = oVar.aZq;
        if (cdVar.My()) {
            oVar2 = this.bjq.bjp;
            frsActivity = oVar2.bhN;
            frsActivity.loadMore();
        }
    }
}
