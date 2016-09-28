package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.view.y;
/* loaded from: classes.dex */
class r implements y.a {
    final /* synthetic */ FrsActivity bQi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(FrsActivity frsActivity) {
        this.bQi = frsActivity;
    }

    @Override // com.baidu.tbadk.core.view.y.a
    public void F(View view) {
        com.baidu.tieba.frs.i.p pVar;
        com.baidu.tieba.frs.i.p pVar2;
        com.baidu.tieba.frs.i.p pVar3;
        com.baidu.tieba.frs.i.p pVar4;
        pVar = this.bQi.bPu;
        if (pVar != null) {
            pVar2 = this.bQi.bPu;
            if (pVar2.afD() != null) {
                pVar3 = this.bQi.bPu;
                if (pVar3.afD().afZ() != null) {
                    pVar4 = this.bQi.bPu;
                    pVar4.afD().afZ().setDoingPullRefresh(false);
                }
            }
        }
    }
}
