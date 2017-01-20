package com.baidu.tieba.frs.f;

import android.view.View;
import com.baidu.tbadk.core.view.aa;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ax;
import com.baidu.tieba.frs.ce;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements aa.a {
    final /* synthetic */ af bVV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(af afVar) {
        this.bVV = afVar;
    }

    @Override // com.baidu.tbadk.core.view.aa.a
    public void D(View view) {
        ax axVar;
        ce ceVar;
        u uVar;
        com.baidu.tieba.frs.smartsort.c cVar;
        u uVar2;
        FrsActivity frsActivity;
        com.baidu.tieba.frs.smartsort.c cVar2;
        u uVar3;
        u uVar4;
        u uVar5;
        axVar = this.bVV.bFF;
        if (axVar != null) {
            ceVar = this.bVV.bSH;
            if (ceVar != null) {
                uVar = this.bVV.bFR;
                if (uVar != null) {
                    cVar = this.bVV.bFY;
                    if (cVar != null) {
                        uVar2 = this.bVV.bFR;
                        if (uVar2 != null) {
                            uVar3 = this.bVV.bFR;
                            if (uVar3.acU() != null) {
                                uVar4 = this.bVV.bFR;
                                if (uVar4.acU().adB() != null) {
                                    uVar5 = this.bVV.bFR;
                                    uVar5.acU().adB().setDoingPullRefresh(false);
                                }
                            }
                        }
                        frsActivity = this.bVV.bLZ;
                        frsActivity.dA(true);
                        cVar2 = this.bVV.bFY;
                        cVar2.acq();
                    }
                }
            }
        }
    }
}
