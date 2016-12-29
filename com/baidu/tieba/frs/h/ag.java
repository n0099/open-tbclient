package com.baidu.tieba.frs.h;

import com.baidu.tbadk.core.view.z;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ax;
import com.baidu.tieba.frs.cg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements z.c {
    final /* synthetic */ ad bPv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ad adVar) {
        this.bPv = adVar;
    }

    @Override // com.baidu.tbadk.core.view.z.c
    public void aN(boolean z) {
        ax axVar;
        cg cgVar;
        s sVar;
        ax axVar2;
        s sVar2;
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        s sVar3;
        s sVar4;
        s sVar5;
        ax axVar3;
        ax axVar4;
        axVar = this.bPv.byg;
        if (axVar != null) {
            cgVar = this.bPv.bMt;
            if (cgVar != null) {
                sVar = this.bPv.bys;
                if (sVar != null) {
                    axVar2 = this.bPv.byg;
                    if (axVar2 != null) {
                        axVar3 = this.bPv.byg;
                        if (axVar3.JI() != null) {
                            axVar4 = this.bPv.byg;
                            axVar4.JI().alQ();
                        }
                    }
                    sVar2 = this.bPv.bys;
                    if (sVar2 != null) {
                        sVar3 = this.bPv.bys;
                        if (sVar3.abN() != null) {
                            sVar4 = this.bPv.bys;
                            if (sVar4.abN().acs() != null) {
                                sVar5 = this.bPv.bys;
                                sVar5.abN().acs().setDoingPullRefresh(true);
                            }
                        }
                    }
                    frsActivity = this.bPv.bFI;
                    frsActivity.dt(false);
                    frsActivity2 = this.bPv.bFI;
                    frsActivity2.mHandler.postDelayed(new ah(this), 110L);
                }
            }
        }
    }
}
