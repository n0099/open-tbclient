package com.baidu.tieba.frs.j;

import com.baidu.tbadk.core.view.z;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.ch;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements z.c {
    final /* synthetic */ y ckm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(y yVar) {
        this.ckm = yVar;
    }

    @Override // com.baidu.tbadk.core.view.z.c
    public void aM(boolean z) {
        au auVar;
        ch chVar;
        n nVar;
        au auVar2;
        n nVar2;
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        n nVar3;
        n nVar4;
        n nVar5;
        au auVar3;
        au auVar4;
        auVar = this.ckm.bRW;
        if (auVar != null) {
            chVar = this.ckm.cgK;
            if (chVar != null) {
                nVar = this.ckm.bSi;
                if (nVar != null) {
                    auVar2 = this.ckm.bRW;
                    if (auVar2 != null) {
                        auVar3 = this.ckm.bRW;
                        if (auVar3.Kp() != null) {
                            auVar4 = this.ckm.bRW;
                            auVar4.Kp().aro();
                        }
                    }
                    nVar2 = this.ckm.bSi;
                    if (nVar2 != null) {
                        nVar3 = this.ckm.bSi;
                        if (nVar3.ahq() != null) {
                            nVar4 = this.ckm.bSi;
                            if (nVar4.ahq().ahV() != null) {
                                nVar5 = this.ckm.bSi;
                                nVar5.ahq().ahV().setDoingPullRefresh(true);
                            }
                        }
                    }
                    frsActivity = this.ckm.bZY;
                    frsActivity.dL(false);
                    frsActivity2 = this.ckm.bZY;
                    frsActivity2.mHandler.postDelayed(new ac(this), 110L);
                }
            }
        }
    }
}
