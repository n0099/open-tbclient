package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class q implements com.baidu.adp.widget.ListView.ak {
    final /* synthetic */ FrsActivity aJQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(FrsActivity frsActivity) {
        this.aJQ = frsActivity;
    }

    @Override // com.baidu.adp.widget.ListView.ak
    public boolean b(View view, com.baidu.adp.widget.ListView.ai aiVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        com.baidu.tbadk.core.data.w wVar;
        com.baidu.tbadk.core.data.w wVar2;
        com.baidu.tbadk.core.data.w wVar3;
        com.baidu.tbadk.core.data.w wVar4;
        com.baidu.tbadk.core.data.w wVar5;
        bf bfVar;
        if (bdUniqueId != null) {
            if (bdUniqueId.getId() == com.baidu.tbadk.core.data.c.OR.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.OS.getId()) {
                this.aJQ.aJg = (com.baidu.tbadk.core.data.w) aiVar;
                wVar = this.aJQ.aJg;
                if (wVar instanceof com.baidu.tbadk.core.data.c) {
                    wVar2 = this.aJQ.aJg;
                    com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) wVar2;
                    if (!cVar.pQ()) {
                        if (cVar.OX == 0) {
                            this.aJQ.a(cVar, i);
                        }
                        TiebaStatic.eventStat(this.aJQ.getPageContext().getPageActivity(), "frs_tb_arc", "");
                    }
                }
            } else if (bdUniqueId.getId() != com.baidu.tieba.tbadkCore.aj.clQ.getId()) {
                if (bdUniqueId.getId() != com.baidu.tbadk.core.data.c.OT.getId() && bdUniqueId.getId() != com.baidu.tbadk.core.data.c.OV.getId() && bdUniqueId.getId() != com.baidu.tbadk.core.data.c.OW.getId()) {
                    this.aJQ.aJg = (com.baidu.tbadk.core.data.w) aiVar;
                    FrsActivity frsActivity = this.aJQ;
                    wVar3 = this.aJQ.aJg;
                    frsActivity.mThreadId = wVar3.getId();
                    wVar4 = this.aJQ.aJg;
                    String qF = wVar4.qF();
                    if (qF == null || qF.equals("")) {
                        this.aJQ.aIY = false;
                    } else {
                        this.aJQ.aIY = true;
                    }
                    FrsActivity frsActivity2 = this.aJQ;
                    wVar5 = this.aJQ.aJg;
                    frsActivity2.a(wVar5);
                    bfVar = this.aJQ.aJa;
                    bfVar.Kf();
                } else if (aiVar instanceof com.baidu.tbadk.core.data.c) {
                    com.baidu.tbadk.core.data.c cVar2 = (com.baidu.tbadk.core.data.c) aiVar;
                    if (cVar2.pP()) {
                        if (cVar2.OX == 0) {
                            this.aJQ.a(cVar2, i);
                        }
                        TiebaStatic.eventStat(this.aJQ.getPageContext().getPageActivity(), "frs_tb_arc", "");
                    }
                }
            }
        }
        return false;
    }
}
