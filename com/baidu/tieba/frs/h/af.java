package com.baidu.tieba.frs.h;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.z;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ax;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements z.b {
    final /* synthetic */ ad bPv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ad adVar) {
        this.bPv = adVar;
    }

    @Override // com.baidu.tbadk.core.view.z.b
    public void aM(boolean z) {
        FrsActivity frsActivity;
        ax axVar;
        FrsActivity frsActivity2;
        ax axVar2;
        FrsActivity frsActivity3;
        FrsActivity frsActivity4;
        FrsActivity frsActivity5;
        FrsActivity frsActivity6;
        frsActivity = this.bPv.bFI;
        frsActivity.refresh();
        axVar = this.bPv.byg;
        if (axVar != null) {
            frsActivity2 = this.bPv.bFI;
            if (frsActivity2.Wv()) {
                frsActivity6 = this.bPv.bFI;
                frsActivity6.Wa().kj();
            }
            axVar2 = this.bPv.byg;
            axVar2.dw(true);
            frsActivity3 = this.bPv.bFI;
            frsActivity3.dt(true);
            at atVar = new at("c11749");
            frsActivity4 = this.bPv.bFI;
            at ab = atVar.ab("fid", frsActivity4.getFid());
            frsActivity5 = this.bPv.bFI;
            TiebaStatic.log(ab.ab("obj_locate", frsActivity5.Wv() ? "2" : "1"));
        }
    }
}
