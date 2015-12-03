package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class r implements com.baidu.adp.widget.ListView.w {
    final /* synthetic */ FrsActivity bag;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(FrsActivity frsActivity) {
        this.bag = frsActivity;
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
        if (bdUniqueId.getId() == com.baidu.tbadk.core.data.b.Uf.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.Ug.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.Uh.getId()) {
            this.bag.aZu = (com.baidu.tbadk.core.data.z) uVar;
            zVar = this.bag.aZu;
            if (zVar instanceof com.baidu.tbadk.core.data.b) {
                zVar2 = this.bag.aZu;
                com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) zVar2;
                if (bVar.rD()) {
                    return false;
                }
                if (bVar.Ul == 0) {
                    this.bag.a(bVar, i);
                }
                TiebaStatic.eventStat(this.bag.getPageContext().getPageActivity(), "frs_tb_arc", "");
            }
        } else if (bdUniqueId.getId() != com.baidu.tieba.tbadkCore.aa.dyo.getId()) {
            if (bdUniqueId.getId() == com.baidu.tbadk.core.data.b.Ui.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.Uj.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.Uk.getId()) {
                if (uVar instanceof com.baidu.tbadk.core.data.b) {
                    com.baidu.tbadk.core.data.b bVar2 = (com.baidu.tbadk.core.data.b) uVar;
                    if (bVar2.rC()) {
                        if (bVar2.Ul == 0) {
                            this.bag.a(bVar2, i);
                        }
                        TiebaStatic.eventStat(this.bag.getPageContext().getPageActivity(), "frs_tb_arc", "");
                    }
                }
            } else if (uVar instanceof com.baidu.tbadk.core.data.z) {
                this.bag.aZu = (com.baidu.tbadk.core.data.z) uVar;
                zVar3 = this.bag.aZu;
                if (!zVar3.isPhotoLiveThread()) {
                    zVar4 = this.bag.aZu;
                    if (!(zVar4 instanceof com.baidu.tbadk.core.data.t)) {
                        FrsActivity frsActivity = this.bag;
                        zVar5 = this.bag.aZu;
                        frsActivity.mThreadId = zVar5.getId();
                        zVar6 = this.bag.aZu;
                        String sN = zVar6.sN();
                        if (sN == null || sN.equals("")) {
                            this.bag.aZo = false;
                        } else {
                            this.bag.aZo = true;
                        }
                        FrsActivity frsActivity2 = this.bag;
                        zVar7 = this.bag.aZu;
                        frsActivity2.a(zVar7);
                        this.bag.aZq.NA();
                    }
                }
            }
        }
        return true;
    }
}
