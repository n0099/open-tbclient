package com.baidu.tieba.frs.e;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.ae;
import com.baidu.tieba.frs.at;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements ae.b {
    final /* synthetic */ ag cbR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ag agVar) {
        this.cbR = agVar;
    }

    @Override // com.baidu.tbadk.core.view.ae.b
    public void aM(boolean z) {
        com.baidu.tieba.frs.r rVar;
        at atVar;
        at atVar2;
        com.baidu.tieba.frs.r rVar2;
        com.baidu.tieba.frs.r rVar3;
        rVar = this.cbR.bNK;
        rVar.refresh();
        atVar = this.cbR.bOn;
        if (atVar != null) {
            atVar2 = this.cbR.bOn;
            atVar2.ci(true);
            rVar2 = this.cbR.bNK;
            rVar2.dL(true);
            as asVar = new as("c11749");
            rVar3 = this.cbR.bNK;
            TiebaStatic.log(asVar.aa("fid", rVar3.getFid()).aa("obj_locate", "1"));
        }
    }
}
