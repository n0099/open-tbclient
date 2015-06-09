package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class q implements com.baidu.adp.widget.ListView.ak {
    final /* synthetic */ FrsActivity aLY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(FrsActivity frsActivity) {
        this.aLY = frsActivity;
    }

    @Override // com.baidu.adp.widget.ListView.ak
    public boolean b(View view, com.baidu.adp.widget.ListView.ai aiVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        com.baidu.tbadk.core.data.w wVar;
        com.baidu.tbadk.core.data.w wVar2;
        com.baidu.tbadk.core.data.w wVar3;
        com.baidu.tbadk.core.data.w wVar4;
        com.baidu.tbadk.core.data.w wVar5;
        bf bfVar;
        if (bdUniqueId == null) {
            return false;
        }
        if (bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Pm.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Pn.getId()) {
            this.aLY.aLp = (com.baidu.tbadk.core.data.w) aiVar;
            wVar = this.aLY.aLp;
            if (wVar instanceof com.baidu.tbadk.core.data.c) {
                wVar2 = this.aLY.aLp;
                com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) wVar2;
                if (cVar.qw()) {
                    return false;
                }
                if (cVar.Pr == 0) {
                    this.aLY.a(cVar, i);
                }
                TiebaStatic.eventStat(this.aLY.getPageContext().getPageActivity(), "frs_tb_arc", "");
            }
        } else if (bdUniqueId.getId() != com.baidu.tieba.tbadkCore.aj.cpQ.getId()) {
            if (bdUniqueId.getId() != com.baidu.tbadk.core.data.c.Po.getId() && bdUniqueId.getId() != com.baidu.tbadk.core.data.c.Pp.getId() && bdUniqueId.getId() != com.baidu.tbadk.core.data.c.Pq.getId()) {
                this.aLY.aLp = (com.baidu.tbadk.core.data.w) aiVar;
                FrsActivity frsActivity = this.aLY;
                wVar3 = this.aLY.aLp;
                frsActivity.mThreadId = wVar3.getId();
                wVar4 = this.aLY.aLp;
                String rl = wVar4.rl();
                if (rl == null || rl.equals("")) {
                    this.aLY.aLh = false;
                } else {
                    this.aLY.aLh = true;
                }
                FrsActivity frsActivity2 = this.aLY;
                wVar5 = this.aLY.aLp;
                frsActivity2.a(wVar5);
                bfVar = this.aLY.aLj;
                bfVar.Ll();
            } else if (aiVar instanceof com.baidu.tbadk.core.data.c) {
                com.baidu.tbadk.core.data.c cVar2 = (com.baidu.tbadk.core.data.c) aiVar;
                if (cVar2.qv()) {
                    if (cVar2.Pr == 0) {
                        this.aLY.a(cVar2, i);
                    }
                    TiebaStatic.eventStat(this.aLY.getPageContext().getPageActivity(), "frs_tb_arc", "");
                }
            }
        }
        return true;
    }
}
