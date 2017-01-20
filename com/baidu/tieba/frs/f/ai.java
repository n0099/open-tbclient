package com.baidu.tieba.frs.f;

import com.baidu.tbadk.core.view.aa;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ax;
import com.baidu.tieba.frs.ce;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements aa.c {
    final /* synthetic */ af bVV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(af afVar) {
        this.bVV = afVar;
    }

    @Override // com.baidu.tbadk.core.view.aa.c
    public void aN(boolean z) {
        ax axVar;
        ce ceVar;
        u uVar;
        ax axVar2;
        u uVar2;
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        u uVar3;
        u uVar4;
        u uVar5;
        ax axVar3;
        ax axVar4;
        axVar = this.bVV.bFF;
        if (axVar != null) {
            ceVar = this.bVV.bSH;
            if (ceVar != null) {
                uVar = this.bVV.bFR;
                if (uVar != null) {
                    axVar2 = this.bVV.bFF;
                    if (axVar2 != null) {
                        axVar3 = this.bVV.bFF;
                        if (axVar3.JX() != null) {
                            axVar4 = this.bVV.bFF;
                            axVar4.JX().amY();
                        }
                    }
                    uVar2 = this.bVV.bFR;
                    if (uVar2 != null) {
                        uVar3 = this.bVV.bFR;
                        if (uVar3.acU() != null) {
                            uVar4 = this.bVV.bFR;
                            if (uVar4.acU().adB() != null) {
                                uVar5 = this.bVV.bFR;
                                uVar5.acU().adB().setDoingPullRefresh(true);
                            }
                        }
                    }
                    frsActivity = this.bVV.bLZ;
                    frsActivity.dA(false);
                    frsActivity2 = this.bVV.bLZ;
                    frsActivity2.mHandler.postDelayed(new aj(this), 110L);
                }
            }
        }
    }
}
