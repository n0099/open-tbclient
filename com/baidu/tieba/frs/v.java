package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class v implements com.baidu.adp.widget.ListView.w {
    final /* synthetic */ FrsActivity bgz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(FrsActivity frsActivity) {
        this.bgz = frsActivity;
    }

    @Override // com.baidu.adp.widget.ListView.w
    public boolean b(View view, com.baidu.adp.widget.ListView.u uVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        com.baidu.tbadk.core.data.ah ahVar;
        com.baidu.tbadk.core.data.ah ahVar2;
        com.baidu.tbadk.core.data.ah ahVar3;
        com.baidu.tbadk.core.data.ah ahVar4;
        com.baidu.tbadk.core.data.ah ahVar5;
        com.baidu.tbadk.core.data.ah ahVar6;
        com.baidu.tbadk.core.data.ah ahVar7;
        if (bdUniqueId == null) {
            return false;
        }
        if (bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Um.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Un.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Uo.getId()) {
            this.bgz.bfH = (com.baidu.tbadk.core.data.ah) uVar;
            ahVar = this.bgz.bfH;
            if (ahVar instanceof com.baidu.tbadk.core.data.c) {
                ahVar2 = this.bgz.bfH;
                com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) ahVar2;
                if (cVar.rO()) {
                    return false;
                }
                if (cVar.Us == 0) {
                    this.bgz.a(cVar, i, true);
                }
                TiebaStatic.eventStat(this.bgz.getPageContext().getPageActivity(), "frs_tb_arc", "");
            }
        } else if (bdUniqueId.getId() != com.baidu.tieba.tbadkCore.z.dVD.getId()) {
            if (bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Up.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Uq.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Ur.getId()) {
                if (uVar instanceof com.baidu.tbadk.core.data.c) {
                    com.baidu.tbadk.core.data.c cVar2 = (com.baidu.tbadk.core.data.c) uVar;
                    if (cVar2.rN()) {
                        if (cVar2.Us == 0) {
                            this.bgz.a(cVar2, i, true);
                        }
                        TiebaStatic.eventStat(this.bgz.getPageContext().getPageActivity(), "frs_tb_arc", "");
                    }
                }
            } else if (uVar instanceof com.baidu.tbadk.core.data.ah) {
                this.bgz.bfH = (com.baidu.tbadk.core.data.ah) uVar;
                ahVar3 = this.bgz.bfH;
                if (!ahVar3.isPhotoLiveThread()) {
                    ahVar4 = this.bgz.bfH;
                    if (!(ahVar4 instanceof com.baidu.tbadk.core.data.x)) {
                        FrsActivity frsActivity = this.bgz;
                        ahVar5 = this.bgz.bfH;
                        frsActivity.mThreadId = ahVar5.getId();
                        ahVar6 = this.bgz.bfH;
                        String tq = ahVar6.tq();
                        if (tq == null || tq.equals("")) {
                            this.bgz.bfB = false;
                        } else {
                            this.bgz.bfB = true;
                        }
                        FrsActivity frsActivity2 = this.bgz;
                        ahVar7 = this.bgz.bfH;
                        frsActivity2.c(ahVar7);
                        this.bgz.bfD.PU();
                    }
                }
            }
        }
        return true;
    }
}
