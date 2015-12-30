package com.baidu.tieba.frs.frsgood;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class h implements com.baidu.adp.widget.ListView.w {
    final /* synthetic */ FrsGoodActivity bkp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(FrsGoodActivity frsGoodActivity) {
        this.bkp = frsGoodActivity;
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
        if (bdUniqueId.getId() == com.baidu.tbadk.core.data.b.UF.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.UG.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.UH.getId()) {
            this.bkp.bdq = (com.baidu.tbadk.core.data.z) uVar;
            zVar = this.bkp.bdq;
            if (zVar instanceof com.baidu.tbadk.core.data.b) {
                zVar2 = this.bkp.bdq;
                com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) zVar2;
                if (bVar.rm()) {
                    return false;
                }
                if (bVar.UL == 0) {
                    this.bkp.a(bVar, i, true);
                }
                TiebaStatic.eventStat(this.bkp.getPageContext().getPageActivity(), "frs_tb_arc", "");
            }
        } else if (bdUniqueId.getId() != com.baidu.tbadk.core.data.b.UI.getId() && bdUniqueId.getId() != com.baidu.tbadk.core.data.b.UJ.getId() && bdUniqueId.getId() != com.baidu.tbadk.core.data.b.UK.getId()) {
            this.bkp.bdq = (com.baidu.tbadk.core.data.z) uVar;
            FrsGoodActivity frsGoodActivity = this.bkp;
            zVar3 = this.bkp.bdq;
            frsGoodActivity.mThreadId = zVar3.getId();
            zVar4 = this.bkp.bdq;
            String sx = zVar4.sx();
            if (sx == null || sx.equals("")) {
                this.bkp.bdk = false;
            } else {
                this.bkp.bdk = true;
            }
            FrsGoodActivity frsGoodActivity2 = this.bkp;
            zVar5 = this.bkp.bdq;
            frsGoodActivity2.c(zVar5);
            this.bkp.bkj.NT();
        } else if (uVar instanceof com.baidu.tbadk.core.data.b) {
            com.baidu.tbadk.core.data.b bVar2 = (com.baidu.tbadk.core.data.b) uVar;
            if (bVar2.rl()) {
                if (bVar2.UL == 0) {
                    this.bkp.a(bVar2, i, true);
                }
                TiebaStatic.eventStat(this.bkp.getPageContext().getPageActivity(), "frs_tb_arc", "");
            }
        }
        return true;
    }
}
