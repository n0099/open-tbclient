package com.baidu.tieba.frs.f;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.aa;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ax;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements aa.b {
    final /* synthetic */ af bVV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(af afVar) {
        this.bVV = afVar;
    }

    @Override // com.baidu.tbadk.core.view.aa.b
    public void aM(boolean z) {
        FrsActivity frsActivity;
        ax axVar;
        FrsActivity frsActivity2;
        ax axVar2;
        FrsActivity frsActivity3;
        FrsActivity frsActivity4;
        FrsActivity frsActivity5;
        FrsActivity frsActivity6;
        frsActivity = this.bVV.bLZ;
        frsActivity.refresh();
        axVar = this.bVV.bFF;
        if (axVar != null) {
            frsActivity2 = this.bVV.bLZ;
            if (frsActivity2.XM()) {
                frsActivity6 = this.bVV.bLZ;
                frsActivity6.Xr().kf();
            }
            axVar2 = this.bVV.bFF;
            axVar2.cf(true);
            frsActivity3 = this.bVV.bLZ;
            frsActivity3.dA(true);
            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c11749");
            frsActivity4 = this.bVV.bLZ;
            com.baidu.tbadk.core.util.ar ab = arVar.ab("fid", frsActivity4.getFid());
            frsActivity5 = this.bVV.bLZ;
            TiebaStatic.log(ab.ab("obj_locate", frsActivity5.XM() ? "2" : "1"));
        }
    }
}
