package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class y implements com.baidu.adp.widget.ListView.ao {
    final /* synthetic */ FrsActivity aDT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(FrsActivity frsActivity) {
        this.aDT = frsActivity;
    }

    @Override // com.baidu.adp.widget.ListView.ao
    public boolean b(View view, com.baidu.adp.widget.ListView.am amVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        com.baidu.tbadk.core.data.x xVar;
        com.baidu.tbadk.core.data.x xVar2;
        com.baidu.tbadk.core.data.x xVar3;
        com.baidu.tbadk.core.data.x xVar4;
        com.baidu.tbadk.core.data.x xVar5;
        bp bpVar;
        if (bdUniqueId != null) {
            if (bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Dh.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Di.getId()) {
                this.aDT.aDj = (com.baidu.tbadk.core.data.x) amVar;
                xVar = this.aDT.aDj;
                if (xVar instanceof com.baidu.tbadk.core.data.c) {
                    xVar2 = this.aDT.aDj;
                    com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) xVar2;
                    if (!cVar.mp()) {
                        if (cVar.Dj == 0) {
                            this.aDT.a(cVar, i);
                        }
                        TiebaStatic.eventStat(this.aDT.getPageContext().getPageActivity(), "frs_tb_arc", "");
                    }
                }
            } else if (bdUniqueId.getId() != com.baidu.tieba.tbadkCore.ag.bUU.getId()) {
                this.aDT.aDj = (com.baidu.tbadk.core.data.x) amVar;
                FrsActivity frsActivity = this.aDT;
                xVar3 = this.aDT.aDj;
                frsActivity.mThreadId = xVar3.getId();
                xVar4 = this.aDT.aDj;
                String np = xVar4.np();
                if (np == null || np.equals("")) {
                    this.aDT.aCU = false;
                } else {
                    this.aDT.aCU = true;
                }
                FrsActivity frsActivity2 = this.aDT;
                xVar5 = this.aDT.aDj;
                frsActivity2.a(xVar5);
                bpVar = this.aDT.aCV;
                bpVar.GH();
            }
        }
        return false;
    }
}
