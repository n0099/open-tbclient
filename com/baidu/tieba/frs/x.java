package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class x implements com.baidu.adp.widget.ListView.w {
    final /* synthetic */ FrsActivity blk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(FrsActivity frsActivity) {
        this.blk = frsActivity;
    }

    @Override // com.baidu.adp.widget.ListView.w
    public boolean b(View view, com.baidu.adp.widget.ListView.u uVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        com.baidu.tbadk.core.data.as asVar;
        com.baidu.tbadk.core.data.as asVar2;
        com.baidu.tbadk.core.data.as asVar3;
        com.baidu.tbadk.core.data.as asVar4;
        com.baidu.tbadk.core.data.as asVar5;
        com.baidu.tbadk.core.data.as asVar6;
        com.baidu.tbadk.core.data.as asVar7;
        if (bdUniqueId == null) {
            return false;
        }
        if (bdUniqueId.getId() == com.baidu.tbadk.core.data.c.RS.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.RT.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.RU.getId()) {
            this.blk.bks = (com.baidu.tbadk.core.data.as) uVar;
            asVar = this.blk.bks;
            if (asVar instanceof com.baidu.tbadk.core.data.c) {
                asVar2 = this.blk.bks;
                com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) asVar2;
                if (cVar.rm()) {
                    return false;
                }
                if (cVar.RY == 0) {
                    this.blk.a(cVar, i, true);
                }
                TiebaStatic.eventStat(this.blk.getPageContext().getPageActivity(), "frs_tb_arc", "");
            }
        } else if (bdUniqueId.getId() != com.baidu.tieba.tbadkCore.z.eoi.getId()) {
            if (bdUniqueId.getId() == com.baidu.tbadk.core.data.c.RV.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.RW.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.RX.getId()) {
                if (uVar instanceof com.baidu.tbadk.core.data.c) {
                    com.baidu.tbadk.core.data.c cVar2 = (com.baidu.tbadk.core.data.c) uVar;
                    if (cVar2.rl()) {
                        if (cVar2.RY == 0) {
                            this.blk.a(cVar2, i, true);
                        }
                        TiebaStatic.eventStat(this.blk.getPageContext().getPageActivity(), "frs_tb_arc", "");
                    }
                }
            } else if (uVar instanceof com.baidu.tbadk.core.data.as) {
                this.blk.bks = (com.baidu.tbadk.core.data.as) uVar;
                asVar3 = this.blk.bks;
                if (!asVar3.isPhotoLiveThread()) {
                    asVar4 = this.blk.bks;
                    if (!(asVar4 instanceof com.baidu.tbadk.core.data.af)) {
                        FrsActivity frsActivity = this.blk;
                        asVar5 = this.blk.bks;
                        frsActivity.mThreadId = asVar5.getId();
                        asVar6 = this.blk.bks;
                        String tt = asVar6.tt();
                        if (tt == null || tt.equals("")) {
                            this.blk.bkm = false;
                        } else {
                            this.blk.bkm = true;
                        }
                        FrsActivity frsActivity2 = this.blk;
                        asVar7 = this.blk.bks;
                        frsActivity2.c(asVar7);
                        this.blk.bko.RN();
                    }
                }
            }
        }
        return true;
    }
}
