package com.baidu.tieba.frs.g;

import com.baidu.tbadk.core.view.ab;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.az;
import com.baidu.tieba.frs.cg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements ab.c {
    final /* synthetic */ ah cei;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ah ahVar) {
        this.cei = ahVar;
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
        azVar = this.cei.bOU;
        if (azVar != null) {
            cgVar = this.cei.caL;
            if (cgVar != null) {
                uVar = this.cei.bPg;
                if (uVar != null) {
                    azVar2 = this.cei.bOU;
                    if (azVar2 != null) {
                        azVar3 = this.cei.bOU;
                        if (azVar3.Lc() != null) {
                            azVar4 = this.cei.bOU;
                            azVar4.Lc().amG();
                        }
                    }
                    frsActivity = this.cei.bVk;
                    frsActivity.dM(false);
                    frsActivity2 = this.cei.bVk;
                    frsActivity2.mHandler.postDelayed(new al(this), 110L);
                }
            }
        }
    }
}
