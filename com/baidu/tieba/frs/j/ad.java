package com.baidu.tieba.frs.j;

import android.view.View;
import com.baidu.tbadk.core.view.z;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.ch;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements z.a {
    final /* synthetic */ y ckm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(y yVar) {
        this.ckm = yVar;
    }

    @Override // com.baidu.tbadk.core.view.z.a
    public void F(View view) {
        au auVar;
        ch chVar;
        n nVar;
        com.baidu.tieba.frs.g.d dVar;
        n nVar2;
        FrsActivity frsActivity;
        com.baidu.tieba.frs.g.d dVar2;
        n nVar3;
        n nVar4;
        n nVar5;
        auVar = this.ckm.bRW;
        if (auVar != null) {
            chVar = this.ckm.cgK;
            if (chVar != null) {
                nVar = this.ckm.bSi;
                if (nVar != null) {
                    dVar = this.ckm.bSp;
                    if (dVar != null) {
                        nVar2 = this.ckm.bSi;
                        if (nVar2 != null) {
                            nVar3 = this.ckm.bSi;
                            if (nVar3.ahq() != null) {
                                nVar4 = this.ckm.bSi;
                                if (nVar4.ahq().ahV() != null) {
                                    nVar5 = this.ckm.bSi;
                                    nVar5.ahq().ahV().setDoingPullRefresh(false);
                                }
                            }
                        }
                        frsActivity = this.ckm.bZY;
                        frsActivity.dL(true);
                        dVar2 = this.ckm.bSp;
                        dVar2.agO();
                    }
                }
            }
        }
    }
}
