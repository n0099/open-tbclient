package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class y implements com.baidu.adp.widget.ListView.x {
    final /* synthetic */ FrsActivity bhl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(FrsActivity frsActivity) {
        this.bhl = frsActivity;
    }

    @Override // com.baidu.adp.widget.ListView.x
    public boolean b(View view, com.baidu.adp.widget.ListView.v vVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        com.baidu.tbadk.core.data.ax axVar;
        com.baidu.tbadk.core.data.ax axVar2;
        com.baidu.tbadk.core.data.ax axVar3;
        com.baidu.tbadk.core.data.ax axVar4;
        com.baidu.tbadk.core.data.ax axVar5;
        com.baidu.tbadk.core.data.ax axVar6;
        com.baidu.tbadk.core.data.ax axVar7;
        cn cnVar;
        if (bdUniqueId == null) {
            return false;
        }
        if (bdUniqueId.getId() == com.baidu.tbadk.core.data.c.MG.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.MH.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.MI.getId()) {
            this.bhl.bgt = (com.baidu.tbadk.core.data.ax) vVar;
            axVar = this.bhl.bgt;
            if (axVar instanceof com.baidu.tbadk.core.data.c) {
                axVar2 = this.bhl.bgt;
                com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) axVar2;
                if (cVar.oH()) {
                    return false;
                }
                if (cVar.MM == 0) {
                    this.bhl.a(cVar, i, true);
                }
                TiebaStatic.eventStat(this.bhl.getPageContext().getPageActivity(), "frs_tb_arc", "");
            }
        } else if (bdUniqueId.getId() != com.baidu.tieba.tbadkCore.aa.erz.getId()) {
            if (bdUniqueId.getId() == com.baidu.tbadk.core.data.c.MJ.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.MK.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.ML.getId()) {
                if (vVar instanceof com.baidu.tbadk.core.data.c) {
                    com.baidu.tbadk.core.data.c cVar2 = (com.baidu.tbadk.core.data.c) vVar;
                    if (cVar2.oG()) {
                        if (cVar2.MM == 0) {
                            this.bhl.a(cVar2, i, true);
                        }
                        TiebaStatic.eventStat(this.bhl.getPageContext().getPageActivity(), "frs_tb_arc", "");
                    }
                }
            } else if (vVar instanceof com.baidu.tbadk.core.data.ax) {
                this.bhl.bgt = (com.baidu.tbadk.core.data.ax) vVar;
                axVar3 = this.bhl.bgt;
                if (!axVar3.isPhotoLiveThread()) {
                    axVar4 = this.bhl.bgt;
                    if (!(axVar4 instanceof com.baidu.tbadk.core.data.ah)) {
                        FrsActivity frsActivity = this.bhl;
                        axVar5 = this.bhl.bgt;
                        frsActivity.mThreadId = axVar5.getId();
                        axVar6 = this.bhl.bgt;
                        String qR = axVar6.qR();
                        if (qR == null || qR.equals("")) {
                            this.bhl.bgm = false;
                        } else {
                            this.bhl.bgm = true;
                        }
                        FrsActivity frsActivity2 = this.bhl;
                        axVar7 = this.bhl.bgt;
                        frsActivity2.c(axVar7);
                        cnVar = this.bhl.bgo;
                        cnVar.QL();
                    }
                }
            }
        }
        return true;
    }
}
