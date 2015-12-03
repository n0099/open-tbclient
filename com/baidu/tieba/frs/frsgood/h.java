package com.baidu.tieba.frs.frsgood;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class h implements com.baidu.adp.widget.ListView.w {
    final /* synthetic */ FrsGoodActivity bgy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(FrsGoodActivity frsGoodActivity) {
        this.bgy = frsGoodActivity;
    }

    @Override // com.baidu.adp.widget.ListView.w
    public boolean b(View view, com.baidu.adp.widget.ListView.u uVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        com.baidu.tbadk.core.data.z zVar;
        com.baidu.tbadk.core.data.z zVar2;
        com.baidu.tbadk.core.data.z zVar3;
        com.baidu.tbadk.core.data.z zVar4;
        com.baidu.tbadk.core.data.z zVar5;
        if (bdUniqueId == null) {
            return false;
        }
        if (bdUniqueId.getId() == com.baidu.tbadk.core.data.b.Uf.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.Ug.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.Uh.getId()) {
            this.bgy.aZu = (com.baidu.tbadk.core.data.z) uVar;
            zVar = this.bgy.aZu;
            if (zVar instanceof com.baidu.tbadk.core.data.b) {
                zVar2 = this.bgy.aZu;
                com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) zVar2;
                if (bVar.rD()) {
                    return false;
                }
                if (bVar.Ul == 0) {
                    this.bgy.a(bVar, i);
                }
                TiebaStatic.eventStat(this.bgy.getPageContext().getPageActivity(), "frs_tb_arc", "");
            }
        } else if (bdUniqueId.getId() != com.baidu.tbadk.core.data.b.Ui.getId() && bdUniqueId.getId() != com.baidu.tbadk.core.data.b.Uj.getId() && bdUniqueId.getId() != com.baidu.tbadk.core.data.b.Uk.getId()) {
            this.bgy.aZu = (com.baidu.tbadk.core.data.z) uVar;
            FrsGoodActivity frsGoodActivity = this.bgy;
            zVar3 = this.bgy.aZu;
            frsGoodActivity.mThreadId = zVar3.getId();
            zVar4 = this.bgy.aZu;
            String sN = zVar4.sN();
            if (sN == null || sN.equals("")) {
                this.bgy.aZo = false;
            } else {
                this.bgy.aZo = true;
            }
            FrsGoodActivity frsGoodActivity2 = this.bgy;
            zVar5 = this.bgy.aZu;
            frsGoodActivity2.a(zVar5);
            this.bgy.bgr.NA();
        } else if (uVar instanceof com.baidu.tbadk.core.data.b) {
            com.baidu.tbadk.core.data.b bVar2 = (com.baidu.tbadk.core.data.b) uVar;
            if (bVar2.rC()) {
                if (bVar2.Ul == 0) {
                    this.bgy.a(bVar2, i);
                }
                TiebaStatic.eventStat(this.bgy.getPageContext().getPageActivity(), "frs_tb_arc", "");
            }
        }
        return true;
    }
}
