package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class t implements com.baidu.adp.widget.ListView.w {
    final /* synthetic */ FrsActivity aUz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(FrsActivity frsActivity) {
        this.aUz = frsActivity;
    }

    @Override // com.baidu.adp.widget.ListView.w
    public boolean b(View view, com.baidu.adp.widget.ListView.u uVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        com.baidu.tbadk.core.data.v vVar;
        com.baidu.tbadk.core.data.v vVar2;
        com.baidu.tbadk.core.data.v vVar3;
        com.baidu.tbadk.core.data.v vVar4;
        com.baidu.tbadk.core.data.v vVar5;
        com.baidu.tbadk.core.data.v vVar6;
        com.baidu.tbadk.core.data.v vVar7;
        bs bsVar;
        if (bdUniqueId == null) {
            return false;
        }
        if (bdUniqueId.getId() == com.baidu.tbadk.core.data.b.TM.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.TO.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.TP.getId()) {
            this.aUz.aTN = (com.baidu.tbadk.core.data.v) uVar;
            vVar = this.aUz.aTN;
            if (vVar instanceof com.baidu.tbadk.core.data.b) {
                vVar2 = this.aUz.aTN;
                com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) vVar2;
                if (bVar.rr()) {
                    return false;
                }
                if (bVar.TT == 0) {
                    this.aUz.a(bVar, i);
                }
                TiebaStatic.eventStat(this.aUz.getPageContext().getPageActivity(), "frs_tb_arc", "");
            }
        } else if (bdUniqueId.getId() != com.baidu.tieba.tbadkCore.z.cXD.getId()) {
            if (bdUniqueId.getId() == com.baidu.tbadk.core.data.b.TQ.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.TR.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.TS.getId()) {
                if (uVar instanceof com.baidu.tbadk.core.data.b) {
                    com.baidu.tbadk.core.data.b bVar2 = (com.baidu.tbadk.core.data.b) uVar;
                    if (bVar2.rq()) {
                        if (bVar2.TT == 0) {
                            this.aUz.a(bVar2, i);
                        }
                        TiebaStatic.eventStat(this.aUz.getPageContext().getPageActivity(), "frs_tb_arc", "");
                    }
                }
            } else if (uVar instanceof com.baidu.tbadk.core.data.v) {
                this.aUz.aTN = (com.baidu.tbadk.core.data.v) uVar;
                vVar3 = this.aUz.aTN;
                if (!vVar3.isPhotoLiveThread()) {
                    vVar4 = this.aUz.aTN;
                    if (!(vVar4 instanceof com.baidu.tbadk.core.data.p)) {
                        FrsActivity frsActivity = this.aUz;
                        vVar5 = this.aUz.aTN;
                        frsActivity.mThreadId = vVar5.getId();
                        vVar6 = this.aUz.aTN;
                        String sl = vVar6.sl();
                        if (sl == null || sl.equals("")) {
                            this.aUz.aTH = false;
                        } else {
                            this.aUz.aTH = true;
                        }
                        FrsActivity frsActivity2 = this.aUz;
                        vVar7 = this.aUz.aTN;
                        frsActivity2.a(vVar7);
                        bsVar = this.aUz.aTJ;
                        bsVar.LN();
                    }
                }
            }
        }
        return true;
    }
}
