package com.baidu.tieba.frs.c;

import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.cs;
/* loaded from: classes.dex */
class r implements Runnable {
    final /* synthetic */ q buX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.buX = qVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        o oVar;
        cs csVar;
        o oVar2;
        FrsActivity frsActivity;
        oVar = this.buX.buW;
        csVar = oVar.bko;
        if (csVar.QB()) {
            oVar2 = this.buX.buW;
            frsActivity = oVar2.bts;
            frsActivity.Qq();
        }
    }
}
