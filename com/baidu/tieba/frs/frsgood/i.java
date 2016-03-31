package com.baidu.tieba.frs.frsgood;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class i implements com.baidu.adp.widget.ListView.w {
    final /* synthetic */ FrsGoodActivity bsj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FrsGoodActivity frsGoodActivity) {
        this.bsj = frsGoodActivity;
    }

    @Override // com.baidu.adp.widget.ListView.w
    public boolean b(View view, com.baidu.adp.widget.ListView.u uVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        as asVar;
        as asVar2;
        as asVar3;
        as asVar4;
        as asVar5;
        if (bdUniqueId == null) {
            return false;
        }
        if (bdUniqueId.getId() == com.baidu.tbadk.core.data.c.RS.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.RT.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.RU.getId()) {
            this.bsj.bks = (as) uVar;
            asVar = this.bsj.bks;
            if (asVar instanceof com.baidu.tbadk.core.data.c) {
                asVar2 = this.bsj.bks;
                com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) asVar2;
                if (cVar.rm()) {
                    return false;
                }
                if (cVar.RY == 0) {
                    this.bsj.a(cVar, i, true);
                }
                TiebaStatic.eventStat(this.bsj.getPageContext().getPageActivity(), "frs_tb_arc", "");
            }
        } else if (bdUniqueId.getId() != com.baidu.tbadk.core.data.c.RV.getId() && bdUniqueId.getId() != com.baidu.tbadk.core.data.c.RW.getId() && bdUniqueId.getId() != com.baidu.tbadk.core.data.c.RX.getId()) {
            this.bsj.bks = (as) uVar;
            FrsGoodActivity frsGoodActivity = this.bsj;
            asVar3 = this.bsj.bks;
            frsGoodActivity.mThreadId = asVar3.getId();
            asVar4 = this.bsj.bks;
            String tt = asVar4.tt();
            if (tt == null || tt.equals("")) {
                this.bsj.bkm = false;
            } else {
                this.bsj.bkm = true;
            }
            FrsGoodActivity frsGoodActivity2 = this.bsj;
            asVar5 = this.bsj.bks;
            frsGoodActivity2.c(asVar5);
            this.bsj.bsd.RN();
        } else if (uVar instanceof com.baidu.tbadk.core.data.c) {
            com.baidu.tbadk.core.data.c cVar2 = (com.baidu.tbadk.core.data.c) uVar;
            if (cVar2.rl()) {
                if (cVar2.RY == 0) {
                    this.bsj.a(cVar2, i, true);
                }
                TiebaStatic.eventStat(this.bsj.getPageContext().getPageActivity(), "frs_tb_arc", "");
            }
        }
        return true;
    }
}
