package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class s implements com.baidu.adp.widget.ListView.w {
    final /* synthetic */ FrsActivity bed;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(FrsActivity frsActivity) {
        this.bed = frsActivity;
    }

    @Override // com.baidu.adp.widget.ListView.w
    public boolean b(View view, com.baidu.adp.widget.ListView.u uVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        com.baidu.tbadk.core.data.z zVar;
        com.baidu.tbadk.core.data.z zVar2;
        com.baidu.tbadk.core.data.z zVar3;
        com.baidu.tbadk.core.data.z zVar4;
        com.baidu.tbadk.core.data.z zVar5;
        com.baidu.tbadk.core.data.z zVar6;
        com.baidu.tbadk.core.data.z zVar7;
        if (bdUniqueId == null) {
            return false;
        }
        if (bdUniqueId.getId() == com.baidu.tbadk.core.data.b.UF.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.UG.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.UH.getId()) {
            this.bed.bdq = (com.baidu.tbadk.core.data.z) uVar;
            zVar = this.bed.bdq;
            if (zVar instanceof com.baidu.tbadk.core.data.b) {
                zVar2 = this.bed.bdq;
                com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) zVar2;
                if (bVar.rm()) {
                    return false;
                }
                if (bVar.UL == 0) {
                    this.bed.a(bVar, i, true);
                }
                TiebaStatic.eventStat(this.bed.getPageContext().getPageActivity(), "frs_tb_arc", "");
            }
        } else if (bdUniqueId.getId() != com.baidu.tieba.tbadkCore.aa.dFI.getId()) {
            if (bdUniqueId.getId() == com.baidu.tbadk.core.data.b.UI.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.UJ.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.UK.getId()) {
                if (uVar instanceof com.baidu.tbadk.core.data.b) {
                    com.baidu.tbadk.core.data.b bVar2 = (com.baidu.tbadk.core.data.b) uVar;
                    if (bVar2.rl()) {
                        if (bVar2.UL == 0) {
                            this.bed.a(bVar2, i, true);
                        }
                        TiebaStatic.eventStat(this.bed.getPageContext().getPageActivity(), "frs_tb_arc", "");
                    }
                }
            } else if (uVar instanceof com.baidu.tbadk.core.data.z) {
                this.bed.bdq = (com.baidu.tbadk.core.data.z) uVar;
                zVar3 = this.bed.bdq;
                if (!zVar3.isPhotoLiveThread()) {
                    zVar4 = this.bed.bdq;
                    if (!(zVar4 instanceof com.baidu.tbadk.core.data.t)) {
                        FrsActivity frsActivity = this.bed;
                        zVar5 = this.bed.bdq;
                        frsActivity.mThreadId = zVar5.getId();
                        zVar6 = this.bed.bdq;
                        String sx = zVar6.sx();
                        if (sx == null || sx.equals("")) {
                            this.bed.bdk = false;
                        } else {
                            this.bed.bdk = true;
                        }
                        FrsActivity frsActivity2 = this.bed;
                        zVar7 = this.bed.bdq;
                        frsActivity2.c(zVar7);
                        this.bed.bdm.NT();
                    }
                }
            }
        }
        return true;
    }
}
