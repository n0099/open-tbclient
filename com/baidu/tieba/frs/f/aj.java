package com.baidu.tieba.frs.f;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ab;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ax;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements ab.b {
    final /* synthetic */ ah cdq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ah ahVar) {
        this.cdq = ahVar;
    }

    @Override // com.baidu.tbadk.core.view.ab.b
    public void aL(boolean z) {
        FrsActivity frsActivity;
        ax axVar;
        FrsActivity frsActivity2;
        ax axVar2;
        FrsActivity frsActivity3;
        FrsActivity frsActivity4;
        FrsActivity frsActivity5;
        FrsActivity frsActivity6;
        frsActivity = this.cdq.bTf;
        frsActivity.refresh();
        axVar = this.cdq.bMN;
        if (axVar != null) {
            frsActivity2 = this.cdq.bTf;
            if (frsActivity2.YL()) {
                frsActivity6 = this.cdq.bTf;
                frsActivity6.Yq().kZ();
            }
            axVar2 = this.cdq.bMN;
            axVar2.ce(true);
            frsActivity3 = this.cdq.bTf;
            frsActivity3.dA(true);
            com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as("c11749");
            frsActivity4 = this.cdq.bTf;
            com.baidu.tbadk.core.util.as Z = asVar.Z("fid", frsActivity4.getFid());
            frsActivity5 = this.cdq.bTf;
            TiebaStatic.log(Z.Z("obj_locate", frsActivity5.YL() ? "2" : "1"));
        }
    }
}
