package com.baidu.tieba.frs.j;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.z;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.au;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements z.b {
    final /* synthetic */ y ckm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(y yVar) {
        this.ckm = yVar;
    }

    @Override // com.baidu.tbadk.core.view.z.b
    public void aL(boolean z) {
        FrsActivity frsActivity;
        au auVar;
        FrsActivity frsActivity2;
        au auVar2;
        FrsActivity frsActivity3;
        FrsActivity frsActivity4;
        FrsActivity frsActivity5;
        FrsActivity frsActivity6;
        frsActivity = this.ckm.bZY;
        frsActivity.refresh();
        auVar = this.ckm.bRW;
        if (auVar != null) {
            frsActivity2 = this.ckm.bZY;
            if (frsActivity2.ach()) {
                frsActivity6 = this.ckm.bZY;
                frsActivity6.abL().kj();
            }
            auVar2 = this.ckm.bRW;
            auVar2.dO(true);
            frsActivity3 = this.ckm.bZY;
            frsActivity3.dL(true);
            av avVar = new av("c11749");
            frsActivity4 = this.ckm.bZY;
            av ab = avVar.ab("fid", frsActivity4.getFid());
            frsActivity5 = this.ckm.bZY;
            TiebaStatic.log(ab.ab("obj_locate", frsActivity5.ach() ? "2" : "1"));
        }
    }
}
