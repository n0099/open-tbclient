package com.baidu.tieba.frs.frsgood;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class h implements com.baidu.adp.widget.ListView.w {
    final /* synthetic */ FrsGoodActivity aZM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(FrsGoodActivity frsGoodActivity) {
        this.aZM = frsGoodActivity;
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
        if (bdUniqueId.getId() == com.baidu.tbadk.core.data.b.TO.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.TP.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.TQ.getId()) {
            this.aZM.aTY = (com.baidu.tbadk.core.data.w) uVar;
            wVar = this.aZM.aTY;
            if (wVar instanceof com.baidu.tbadk.core.data.b) {
                wVar2 = this.aZM.aTY;
                com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) wVar2;
                if (bVar.ro()) {
                    return false;
                }
                if (bVar.TU == 0) {
                    this.aZM.a(bVar, i);
                }
                TiebaStatic.eventStat(this.aZM.getPageContext().getPageActivity(), "frs_tb_arc", "");
            }
        } else if (bdUniqueId.getId() != com.baidu.tbadk.core.data.b.TR.getId() && bdUniqueId.getId() != com.baidu.tbadk.core.data.b.TS.getId() && bdUniqueId.getId() != com.baidu.tbadk.core.data.b.TT.getId()) {
            this.aZM.aTY = (com.baidu.tbadk.core.data.w) uVar;
            FrsGoodActivity frsGoodActivity = this.aZM;
            wVar3 = this.aZM.aTY;
            frsGoodActivity.mThreadId = wVar3.getId();
            wVar4 = this.aZM.aTY;
            String si = wVar4.si();
            if (si == null || si.equals("")) {
                this.aZM.aTS = false;
            } else {
                this.aZM.aTS = true;
            }
            FrsGoodActivity frsGoodActivity2 = this.aZM;
            wVar5 = this.aZM.aTY;
            frsGoodActivity2.a(wVar5);
            this.aZM.aZG.LJ();
        } else if (uVar instanceof com.baidu.tbadk.core.data.b) {
            com.baidu.tbadk.core.data.b bVar2 = (com.baidu.tbadk.core.data.b) uVar;
            if (bVar2.rn()) {
                if (bVar2.TU == 0) {
                    this.aZM.a(bVar2, i);
                }
                TiebaStatic.eventStat(this.aZM.getPageContext().getPageActivity(), "frs_tb_arc", "");
            }
        }
        return true;
    }
}
