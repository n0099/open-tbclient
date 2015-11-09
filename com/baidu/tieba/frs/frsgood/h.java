package com.baidu.tieba.frs.frsgood;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class h implements com.baidu.adp.widget.ListView.w {
    final /* synthetic */ FrsGoodActivity baf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(FrsGoodActivity frsGoodActivity) {
        this.baf = frsGoodActivity;
    }

    @Override // com.baidu.adp.widget.ListView.w
    public boolean b(View view, com.baidu.adp.widget.ListView.u uVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        com.baidu.tbadk.core.data.w wVar;
        com.baidu.tbadk.core.data.w wVar2;
        com.baidu.tbadk.core.data.w wVar3;
        com.baidu.tbadk.core.data.w wVar4;
        com.baidu.tbadk.core.data.w wVar5;
        if (bdUniqueId == null) {
            return false;
        }
        if (bdUniqueId.getId() == com.baidu.tbadk.core.data.b.TP.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.TQ.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.TR.getId()) {
            this.baf.aUg = (com.baidu.tbadk.core.data.w) uVar;
            wVar = this.baf.aUg;
            if (wVar instanceof com.baidu.tbadk.core.data.b) {
                wVar2 = this.baf.aUg;
                com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) wVar2;
                if (bVar.rp()) {
                    return false;
                }
                if (bVar.TV == 0) {
                    this.baf.a(bVar, i);
                }
                TiebaStatic.eventStat(this.baf.getPageContext().getPageActivity(), "frs_tb_arc", "");
            }
        } else if (bdUniqueId.getId() != com.baidu.tbadk.core.data.b.TS.getId() && bdUniqueId.getId() != com.baidu.tbadk.core.data.b.TT.getId() && bdUniqueId.getId() != com.baidu.tbadk.core.data.b.TU.getId()) {
            this.baf.aUg = (com.baidu.tbadk.core.data.w) uVar;
            FrsGoodActivity frsGoodActivity = this.baf;
            wVar3 = this.baf.aUg;
            frsGoodActivity.mThreadId = wVar3.getId();
            wVar4 = this.baf.aUg;
            String sl = wVar4.sl();
            if (sl == null || sl.equals("")) {
                this.baf.aUa = false;
            } else {
                this.baf.aUa = true;
            }
            FrsGoodActivity frsGoodActivity2 = this.baf;
            wVar5 = this.baf.aUg;
            frsGoodActivity2.a(wVar5);
            this.baf.aZZ.LZ();
        } else if (uVar instanceof com.baidu.tbadk.core.data.b) {
            com.baidu.tbadk.core.data.b bVar2 = (com.baidu.tbadk.core.data.b) uVar;
            if (bVar2.ro()) {
                if (bVar2.TV == 0) {
                    this.baf.a(bVar2, i);
                }
                TiebaStatic.eventStat(this.baf.getPageContext().getPageActivity(), "frs_tb_arc", "");
            }
        }
        return true;
    }
}
