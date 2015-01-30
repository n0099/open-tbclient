package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class y implements com.baidu.adp.widget.ListView.ao {
    final /* synthetic */ FrsActivity aDW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(FrsActivity frsActivity) {
        this.aDW = frsActivity;
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
            if (bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Dk.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Dl.getId()) {
                this.aDW.aDm = (com.baidu.tbadk.core.data.x) amVar;
                xVar = this.aDW.aDm;
                if (xVar instanceof com.baidu.tbadk.core.data.c) {
                    xVar2 = this.aDW.aDm;
                    com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) xVar2;
                    if (!cVar.mw()) {
                        if (cVar.Dm == 0) {
                            this.aDW.a(cVar, i);
                        }
                        TiebaStatic.eventStat(this.aDW.getPageContext().getPageActivity(), "frs_tb_arc", "");
                    }
                }
            } else if (bdUniqueId.getId() != com.baidu.tieba.tbadkCore.ag.bUV.getId()) {
                this.aDW.aDm = (com.baidu.tbadk.core.data.x) amVar;
                FrsActivity frsActivity = this.aDW;
                xVar3 = this.aDW.aDm;
                frsActivity.mThreadId = xVar3.getId();
                xVar4 = this.aDW.aDm;
                String nw = xVar4.nw();
                if (nw == null || nw.equals("")) {
                    this.aDW.aCX = false;
                } else {
                    this.aDW.aCX = true;
                }
                FrsActivity frsActivity2 = this.aDW;
                xVar5 = this.aDW.aDm;
                frsActivity2.a(xVar5);
                bpVar = this.aDW.aCY;
                bpVar.GN();
            }
        }
        return false;
    }
}
