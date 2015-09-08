package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class t implements com.baidu.adp.widget.ListView.w {
    final /* synthetic */ FrsActivity aVz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(FrsActivity frsActivity) {
        this.aVz = frsActivity;
    }

    @Override // com.baidu.adp.widget.ListView.w
    public boolean b(View view, com.baidu.adp.widget.ListView.u uVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        com.baidu.tbadk.core.data.x xVar;
        com.baidu.tbadk.core.data.x xVar2;
        com.baidu.tbadk.core.data.x xVar3;
        com.baidu.tbadk.core.data.x xVar4;
        com.baidu.tbadk.core.data.x xVar5;
        com.baidu.tbadk.core.data.x xVar6;
        com.baidu.tbadk.core.data.x xVar7;
        bi biVar;
        if (bdUniqueId == null) {
            return false;
        }
        if (bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Uc.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Ud.getId()) {
            this.aVz.aUP = (com.baidu.tbadk.core.data.x) uVar;
            xVar = this.aVz.aUP;
            if (xVar instanceof com.baidu.tbadk.core.data.c) {
                xVar2 = this.aVz.aUP;
                com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) xVar2;
                if (cVar.rw()) {
                    return false;
                }
                if (cVar.Uh == 0) {
                    this.aVz.a(cVar, i);
                }
                TiebaStatic.eventStat(this.aVz.getPageContext().getPageActivity(), "frs_tb_arc", "");
            }
        } else if (bdUniqueId.getId() != com.baidu.tieba.tbadkCore.z.cQk.getId()) {
            if (bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Ue.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Uf.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Ug.getId()) {
                if (uVar instanceof com.baidu.tbadk.core.data.c) {
                    com.baidu.tbadk.core.data.c cVar2 = (com.baidu.tbadk.core.data.c) uVar;
                    if (cVar2.rv()) {
                        if (cVar2.Uh == 0) {
                            this.aVz.a(cVar2, i);
                        }
                        TiebaStatic.eventStat(this.aVz.getPageContext().getPageActivity(), "frs_tb_arc", "");
                    }
                }
            } else if (uVar instanceof com.baidu.tbadk.core.data.x) {
                this.aVz.aUP = (com.baidu.tbadk.core.data.x) uVar;
                xVar3 = this.aVz.aUP;
                if (!xVar3.isPhotoLiveThread()) {
                    xVar4 = this.aVz.aUP;
                    if (!(xVar4 instanceof com.baidu.tbadk.core.data.q)) {
                        FrsActivity frsActivity = this.aVz;
                        xVar5 = this.aVz.aUP;
                        frsActivity.mThreadId = xVar5.getId();
                        xVar6 = this.aVz.aUP;
                        String sq = xVar6.sq();
                        if (sq == null || sq.equals("")) {
                            this.aVz.aUJ = false;
                        } else {
                            this.aVz.aUJ = true;
                        }
                        FrsActivity frsActivity2 = this.aVz;
                        xVar7 = this.aVz.aUP;
                        frsActivity2.b(xVar7);
                        biVar = this.aVz.aUL;
                        biVar.LO();
                    }
                }
            }
        }
        return true;
    }
}
