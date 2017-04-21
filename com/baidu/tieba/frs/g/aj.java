package com.baidu.tieba.frs.g;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ab;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.az;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements ab.b {
    final /* synthetic */ ah cei;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ah ahVar) {
        this.cei = ahVar;
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
        frsActivity = this.cei.bVk;
        frsActivity.refresh();
        azVar = this.cei.bOU;
        if (azVar != null) {
            frsActivity2 = this.cei.bVk;
            if (frsActivity2.aai()) {
                frsActivity6 = this.cei.bVk;
                frsActivity6.ZO().le();
            }
            azVar2 = this.cei.bOU;
            azVar2.cg(true);
            frsActivity3 = this.cei.bVk;
            frsActivity3.dM(true);
            com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as("c11749");
            frsActivity4 = this.cei.bVk;
            com.baidu.tbadk.core.util.as aa = asVar.aa("fid", frsActivity4.getFid());
            frsActivity5 = this.cei.bVk;
            TiebaStatic.log(aa.aa("obj_locate", frsActivity5.aai() ? "2" : "1"));
        }
    }
}
