package com.baidu.tieba.frs.h;

import android.view.View;
import com.baidu.tbadk.core.view.z;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ax;
import com.baidu.tieba.frs.cg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements z.a {
    final /* synthetic */ ad bPv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ad adVar) {
        this.bPv = adVar;
    }

    @Override // com.baidu.tbadk.core.view.z.a
    public void F(View view) {
        ax axVar;
        cg cgVar;
        s sVar;
        com.baidu.tieba.frs.f.d dVar;
        s sVar2;
        FrsActivity frsActivity;
        com.baidu.tieba.frs.f.d dVar2;
        s sVar3;
        s sVar4;
        s sVar5;
        axVar = this.bPv.byg;
        if (axVar != null) {
            cgVar = this.bPv.bMt;
            if (cgVar != null) {
                sVar = this.bPv.bys;
                if (sVar != null) {
                    dVar = this.bPv.byz;
                    if (dVar != null) {
                        sVar2 = this.bPv.bys;
                        if (sVar2 != null) {
                            sVar3 = this.bPv.bys;
                            if (sVar3.abN() != null) {
                                sVar4 = this.bPv.bys;
                                if (sVar4.abN().acs() != null) {
                                    sVar5 = this.bPv.bys;
                                    sVar5.abN().acs().setDoingPullRefresh(false);
                                }
                            }
                        }
                        frsActivity = this.bPv.bFI;
                        frsActivity.dt(true);
                        dVar2 = this.bPv.byz;
                        dVar2.abj();
                    }
                }
            }
        }
    }
}
