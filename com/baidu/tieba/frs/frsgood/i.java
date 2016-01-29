package com.baidu.tieba.frs.frsgood;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class i implements com.baidu.adp.widget.ListView.w {
    final /* synthetic */ FrsGoodActivity bnm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FrsGoodActivity frsGoodActivity) {
        this.bnm = frsGoodActivity;
    }

    @Override // com.baidu.adp.widget.ListView.w
    public boolean b(View view, com.baidu.adp.widget.ListView.u uVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        com.baidu.tbadk.core.data.ah ahVar;
        com.baidu.tbadk.core.data.ah ahVar2;
        com.baidu.tbadk.core.data.ah ahVar3;
        com.baidu.tbadk.core.data.ah ahVar4;
        com.baidu.tbadk.core.data.ah ahVar5;
        if (bdUniqueId == null) {
            return false;
        }
        if (bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Um.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Un.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Uo.getId()) {
            this.bnm.bfH = (com.baidu.tbadk.core.data.ah) uVar;
            ahVar = this.bnm.bfH;
            if (ahVar instanceof com.baidu.tbadk.core.data.c) {
                ahVar2 = this.bnm.bfH;
                com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) ahVar2;
                if (cVar.rO()) {
                    return false;
                }
                if (cVar.Us == 0) {
                    this.bnm.a(cVar, i, true);
                }
                TiebaStatic.eventStat(this.bnm.getPageContext().getPageActivity(), "frs_tb_arc", "");
            }
        } else if (bdUniqueId.getId() != com.baidu.tbadk.core.data.c.Up.getId() && bdUniqueId.getId() != com.baidu.tbadk.core.data.c.Uq.getId() && bdUniqueId.getId() != com.baidu.tbadk.core.data.c.Ur.getId()) {
            this.bnm.bfH = (com.baidu.tbadk.core.data.ah) uVar;
            FrsGoodActivity frsGoodActivity = this.bnm;
            ahVar3 = this.bnm.bfH;
            frsGoodActivity.mThreadId = ahVar3.getId();
            ahVar4 = this.bnm.bfH;
            String tq = ahVar4.tq();
            if (tq == null || tq.equals("")) {
                this.bnm.bfB = false;
            } else {
                this.bnm.bfB = true;
            }
            FrsGoodActivity frsGoodActivity2 = this.bnm;
            ahVar5 = this.bnm.bfH;
            frsGoodActivity2.c(ahVar5);
            this.bnm.bng.PU();
        } else if (uVar instanceof com.baidu.tbadk.core.data.c) {
            com.baidu.tbadk.core.data.c cVar2 = (com.baidu.tbadk.core.data.c) uVar;
            if (cVar2.rN()) {
                if (cVar2.Us == 0) {
                    this.bnm.a(cVar2, i, true);
                }
                TiebaStatic.eventStat(this.bnm.getPageContext().getPageActivity(), "frs_tb_arc", "");
            }
        }
        return true;
    }
}
