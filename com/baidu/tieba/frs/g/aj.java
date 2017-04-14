package com.baidu.tieba.frs.g;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ab;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.az;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements ab.b {
    final /* synthetic */ ah cbR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ah ahVar) {
        this.cbR = ahVar;
    }

    @Override // com.baidu.tbadk.core.view.ab.b
    public void aN(boolean z) {
        FrsActivity frsActivity;
        az azVar;
        FrsActivity frsActivity2;
        az azVar2;
        FrsActivity frsActivity3;
        FrsActivity frsActivity4;
        FrsActivity frsActivity5;
        FrsActivity frsActivity6;
        frsActivity = this.cbR.bST;
        frsActivity.refresh();
        azVar = this.cbR.bMD;
        if (azVar != null) {
            frsActivity2 = this.cbR.bST;
            if (frsActivity2.Zh()) {
                frsActivity6 = this.cbR.bST;
                frsActivity6.YN().ld();
            }
            azVar2 = this.cbR.bMD;
            azVar2.cg(true);
            frsActivity3 = this.cbR.bST;
            frsActivity3.dC(true);
            com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as("c11749");
            frsActivity4 = this.cbR.bST;
            com.baidu.tbadk.core.util.as aa = asVar.aa("fid", frsActivity4.getFid());
            frsActivity5 = this.cbR.bST;
            TiebaStatic.log(aa.aa("obj_locate", frsActivity5.Zh() ? "2" : "1"));
        }
    }
}
