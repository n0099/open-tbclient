package com.baidu.tieba.frs.frsgood;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class h implements com.baidu.adp.widget.ListView.w {
    final /* synthetic */ FrsGoodActivity aZI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(FrsGoodActivity frsGoodActivity) {
        this.aZI = frsGoodActivity;
    }

    @Override // com.baidu.adp.widget.ListView.w
    public boolean b(View view, com.baidu.adp.widget.ListView.u uVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        com.baidu.tbadk.core.data.x xVar;
        com.baidu.tbadk.core.data.x xVar2;
        com.baidu.tbadk.core.data.x xVar3;
        com.baidu.tbadk.core.data.x xVar4;
        com.baidu.tbadk.core.data.x xVar5;
        if (bdUniqueId == null) {
            return false;
        }
        if (bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Uc.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Ud.getId()) {
            this.aZI.aUP = (com.baidu.tbadk.core.data.x) uVar;
            xVar = this.aZI.aUP;
            if (xVar instanceof com.baidu.tbadk.core.data.c) {
                xVar2 = this.aZI.aUP;
                com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) xVar2;
                if (cVar.rw()) {
                    return false;
                }
                if (cVar.Uh == 0) {
                    this.aZI.a(cVar, i);
                }
                TiebaStatic.eventStat(this.aZI.getPageContext().getPageActivity(), "frs_tb_arc", "");
            }
        } else if (bdUniqueId.getId() != com.baidu.tbadk.core.data.c.Ue.getId() && bdUniqueId.getId() != com.baidu.tbadk.core.data.c.Uf.getId() && bdUniqueId.getId() != com.baidu.tbadk.core.data.c.Ug.getId()) {
            this.aZI.aUP = (com.baidu.tbadk.core.data.x) uVar;
            FrsGoodActivity frsGoodActivity = this.aZI;
            xVar3 = this.aZI.aUP;
            frsGoodActivity.mThreadId = xVar3.getId();
            xVar4 = this.aZI.aUP;
            String sq = xVar4.sq();
            if (sq == null || sq.equals("")) {
                this.aZI.aUJ = false;
            } else {
                this.aZI.aUJ = true;
            }
            FrsGoodActivity frsGoodActivity2 = this.aZI;
            xVar5 = this.aZI.aUP;
            frsGoodActivity2.b(xVar5);
            this.aZI.aZC.LO();
        } else if (uVar instanceof com.baidu.tbadk.core.data.c) {
            com.baidu.tbadk.core.data.c cVar2 = (com.baidu.tbadk.core.data.c) uVar;
            if (cVar2.rv()) {
                if (cVar2.Uh == 0) {
                    this.aZI.a(cVar2, i);
                }
                TiebaStatic.eventStat(this.aZI.getPageContext().getPageActivity(), "frs_tb_arc", "");
            }
        }
        return true;
    }
}
