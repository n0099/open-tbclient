package com.baidu.tieba.frs.g;

import com.baidu.tbadk.core.view.ab;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.az;
import com.baidu.tieba.frs.cg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements ab.c {
    final /* synthetic */ ah cbR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ah ahVar) {
        this.cbR = ahVar;
    }

    @Override // com.baidu.tbadk.core.view.ab.c
    public void aO(boolean z) {
        az azVar;
        cg cgVar;
        u uVar;
        az azVar2;
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        az azVar3;
        az azVar4;
        azVar = this.cbR.bMD;
        if (azVar != null) {
            cgVar = this.cbR.bYu;
            if (cgVar != null) {
                uVar = this.cbR.bMP;
                if (uVar != null) {
                    azVar2 = this.cbR.bMD;
                    if (azVar2 != null) {
                        azVar3 = this.cbR.bMD;
                        if (azVar3.Lc() != null) {
                            azVar4 = this.cbR.bMD;
                            azVar4.Lc().alF();
                        }
                    }
                    frsActivity = this.cbR.bST;
                    frsActivity.dC(false);
                    frsActivity2 = this.cbR.bST;
                    frsActivity2.mHandler.postDelayed(new al(this), 110L);
                }
            }
        }
    }
}
