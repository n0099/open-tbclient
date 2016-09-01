package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.view.t;
/* loaded from: classes.dex */
class r implements t.a {
    final /* synthetic */ FrsActivity bQp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(FrsActivity frsActivity) {
        this.bQp = frsActivity;
    }

    @Override // com.baidu.tbadk.core.view.t.a
    public void F(View view) {
        com.baidu.tieba.frs.i.p pVar;
        com.baidu.tieba.frs.i.p pVar2;
        com.baidu.tieba.frs.i.p pVar3;
        com.baidu.tieba.frs.i.p pVar4;
        pVar = this.bQp.bPC;
        if (pVar != null) {
            pVar2 = this.bQp.bPC;
            if (pVar2.afp() != null) {
                pVar3 = this.bQp.bPC;
                if (pVar3.afp().afL() != null) {
                    pVar4 = this.bQp.bPC;
                    pVar4.afp().afL().setDoingPullRefresh(false);
                }
            }
        }
    }
}
