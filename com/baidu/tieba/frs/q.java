package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class q implements com.baidu.adp.widget.ListView.ak {
    final /* synthetic */ FrsActivity aJG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(FrsActivity frsActivity) {
        this.aJG = frsActivity;
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
            if (bdUniqueId.getId() == com.baidu.tbadk.core.data.c.OP.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.OQ.getId()) {
                this.aJG.aIY = (com.baidu.tbadk.core.data.w) aiVar;
                wVar = this.aJG.aIY;
                if (wVar instanceof com.baidu.tbadk.core.data.c) {
                    wVar2 = this.aJG.aIY;
                    com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) wVar2;
                    if (!cVar.pQ()) {
                        if (cVar.OV == 0) {
                            this.aJG.a(cVar, i);
                        }
                        TiebaStatic.eventStat(this.aJG.getPageContext().getPageActivity(), "frs_tb_arc", "");
                    }
                }
            } else if (bdUniqueId.getId() != com.baidu.tieba.tbadkCore.aj.clA.getId()) {
                if (bdUniqueId.getId() != com.baidu.tbadk.core.data.c.OR.getId() && bdUniqueId.getId() != com.baidu.tbadk.core.data.c.OS.getId() && bdUniqueId.getId() != com.baidu.tbadk.core.data.c.OT.getId()) {
                    this.aJG.aIY = (com.baidu.tbadk.core.data.w) aiVar;
                    FrsActivity frsActivity = this.aJG;
                    wVar3 = this.aJG.aIY;
                    frsActivity.mThreadId = wVar3.getId();
                    wVar4 = this.aJG.aIY;
                    String qF = wVar4.qF();
                    if (qF == null || qF.equals("")) {
                        this.aJG.aIQ = false;
                    } else {
                        this.aJG.aIQ = true;
                    }
                    FrsActivity frsActivity2 = this.aJG;
                    wVar5 = this.aJG.aIY;
                    frsActivity2.a(wVar5);
                    bfVar = this.aJG.aIS;
                    bfVar.JY();
                } else if (aiVar instanceof com.baidu.tbadk.core.data.c) {
                    com.baidu.tbadk.core.data.c cVar2 = (com.baidu.tbadk.core.data.c) aiVar;
                    if (cVar2.pP()) {
                        if (cVar2.OV == 0) {
                            this.aJG.a(cVar2, i);
                        }
                        TiebaStatic.eventStat(this.aJG.getPageContext().getPageActivity(), "frs_tb_arc", "");
                    }
                }
            }
        }
        return false;
    }
}
