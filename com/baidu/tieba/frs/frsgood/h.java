package com.baidu.tieba.frs.frsgood;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class h implements com.baidu.adp.widget.ListView.w {
    final /* synthetic */ FrsGoodActivity aZB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(FrsGoodActivity frsGoodActivity) {
        this.aZB = frsGoodActivity;
    }

    @Override // com.baidu.adp.widget.ListView.w
    public boolean b(View view, com.baidu.adp.widget.ListView.u uVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        com.baidu.tbadk.core.data.v vVar;
        com.baidu.tbadk.core.data.v vVar2;
        com.baidu.tbadk.core.data.v vVar3;
        com.baidu.tbadk.core.data.v vVar4;
        com.baidu.tbadk.core.data.v vVar5;
        if (bdUniqueId == null) {
            return false;
        }
        if (bdUniqueId.getId() == com.baidu.tbadk.core.data.b.TM.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.TO.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.TP.getId()) {
            this.aZB.aTN = (com.baidu.tbadk.core.data.v) uVar;
            vVar = this.aZB.aTN;
            if (vVar instanceof com.baidu.tbadk.core.data.b) {
                vVar2 = this.aZB.aTN;
                com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) vVar2;
                if (bVar.rr()) {
                    return false;
                }
                if (bVar.TT == 0) {
                    this.aZB.a(bVar, i);
                }
                TiebaStatic.eventStat(this.aZB.getPageContext().getPageActivity(), "frs_tb_arc", "");
            }
        } else if (bdUniqueId.getId() != com.baidu.tbadk.core.data.b.TQ.getId() && bdUniqueId.getId() != com.baidu.tbadk.core.data.b.TR.getId() && bdUniqueId.getId() != com.baidu.tbadk.core.data.b.TS.getId()) {
            this.aZB.aTN = (com.baidu.tbadk.core.data.v) uVar;
            FrsGoodActivity frsGoodActivity = this.aZB;
            vVar3 = this.aZB.aTN;
            frsGoodActivity.mThreadId = vVar3.getId();
            vVar4 = this.aZB.aTN;
            String sl = vVar4.sl();
            if (sl == null || sl.equals("")) {
                this.aZB.aTH = false;
            } else {
                this.aZB.aTH = true;
            }
            FrsGoodActivity frsGoodActivity2 = this.aZB;
            vVar5 = this.aZB.aTN;
            frsGoodActivity2.a(vVar5);
            this.aZB.aZv.LN();
        } else if (uVar instanceof com.baidu.tbadk.core.data.b) {
            com.baidu.tbadk.core.data.b bVar2 = (com.baidu.tbadk.core.data.b) uVar;
            if (bVar2.rq()) {
                if (bVar2.TT == 0) {
                    this.aZB.a(bVar2, i);
                }
                TiebaStatic.eventStat(this.aZB.getPageContext().getPageActivity(), "frs_tb_arc", "");
            }
        }
        return true;
    }
}
