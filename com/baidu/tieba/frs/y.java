package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class y implements com.baidu.adp.widget.ListView.ao {
    final /* synthetic */ FrsActivity aCV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(FrsActivity frsActivity) {
        this.aCV = frsActivity;
    }

    @Override // com.baidu.adp.widget.ListView.ao
    public boolean b(View view, com.baidu.adp.widget.ListView.am amVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        com.baidu.tbadk.core.data.w wVar;
        com.baidu.tbadk.core.data.w wVar2;
        com.baidu.tbadk.core.data.w wVar3;
        com.baidu.tbadk.core.data.w wVar4;
        com.baidu.tbadk.core.data.w wVar5;
        bq bqVar;
        if (bdUniqueId != null) {
            if (bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Di.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Dj.getId()) {
                this.aCV.aCl = (com.baidu.tbadk.core.data.w) amVar;
                wVar = this.aCV.aCl;
                if (wVar instanceof com.baidu.tbadk.core.data.c) {
                    wVar2 = this.aCV.aCl;
                    com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) wVar2;
                    if (!cVar.mw()) {
                        if (cVar.Dk == 0) {
                            this.aCV.a(cVar, i);
                        }
                        TiebaStatic.eventStat(this.aCV.getPageContext().getPageActivity(), "frs_tb_arc", "");
                    }
                }
            } else if (bdUniqueId.getId() != com.baidu.tieba.tbadkCore.ag.bTc.getId()) {
                this.aCV.aCl = (com.baidu.tbadk.core.data.w) amVar;
                FrsActivity frsActivity = this.aCV;
                wVar3 = this.aCV.aCl;
                frsActivity.mThreadId = wVar3.getId();
                wVar4 = this.aCV.aCl;
                String nu = wVar4.nu();
                if (nu == null || nu.equals("")) {
                    this.aCV.aBW = false;
                } else {
                    this.aCV.aBW = true;
                }
                FrsActivity frsActivity2 = this.aCV;
                wVar5 = this.aCV.aCl;
                frsActivity2.a(wVar5);
                bqVar = this.aCV.aBX;
                bqVar.Gq();
            }
        }
        return false;
    }
}
