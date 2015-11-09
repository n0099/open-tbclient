package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class t implements com.baidu.adp.widget.ListView.w {
    final /* synthetic */ FrsActivity aUS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(FrsActivity frsActivity) {
        this.aUS = frsActivity;
    }

    @Override // com.baidu.adp.widget.ListView.w
    public boolean b(View view, com.baidu.adp.widget.ListView.u uVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        com.baidu.tbadk.core.data.w wVar;
        com.baidu.tbadk.core.data.w wVar2;
        com.baidu.tbadk.core.data.w wVar3;
        com.baidu.tbadk.core.data.w wVar4;
        com.baidu.tbadk.core.data.w wVar5;
        com.baidu.tbadk.core.data.w wVar6;
        com.baidu.tbadk.core.data.w wVar7;
        bs bsVar;
        if (bdUniqueId == null) {
            return false;
        }
        if (bdUniqueId.getId() == com.baidu.tbadk.core.data.b.TP.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.TQ.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.TR.getId()) {
            this.aUS.aUg = (com.baidu.tbadk.core.data.w) uVar;
            wVar = this.aUS.aUg;
            if (wVar instanceof com.baidu.tbadk.core.data.b) {
                wVar2 = this.aUS.aUg;
                com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) wVar2;
                if (bVar.rp()) {
                    return false;
                }
                if (bVar.TV == 0) {
                    this.aUS.a(bVar, i);
                }
                TiebaStatic.eventStat(this.aUS.getPageContext().getPageActivity(), "frs_tb_arc", "");
            }
        } else if (bdUniqueId.getId() != com.baidu.tieba.tbadkCore.z.cZA.getId()) {
            if (bdUniqueId.getId() == com.baidu.tbadk.core.data.b.TS.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.TT.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.TU.getId()) {
                if (uVar instanceof com.baidu.tbadk.core.data.b) {
                    com.baidu.tbadk.core.data.b bVar2 = (com.baidu.tbadk.core.data.b) uVar;
                    if (bVar2.ro()) {
                        if (bVar2.TV == 0) {
                            this.aUS.a(bVar2, i);
                        }
                        TiebaStatic.eventStat(this.aUS.getPageContext().getPageActivity(), "frs_tb_arc", "");
                    }
                }
            } else if (uVar instanceof com.baidu.tbadk.core.data.w) {
                this.aUS.aUg = (com.baidu.tbadk.core.data.w) uVar;
                wVar3 = this.aUS.aUg;
                if (!wVar3.isPhotoLiveThread()) {
                    wVar4 = this.aUS.aUg;
                    if (!(wVar4 instanceof com.baidu.tbadk.core.data.q)) {
                        FrsActivity frsActivity = this.aUS;
                        wVar5 = this.aUS.aUg;
                        frsActivity.mThreadId = wVar5.getId();
                        wVar6 = this.aUS.aUg;
                        String sl = wVar6.sl();
                        if (sl == null || sl.equals("")) {
                            this.aUS.aUa = false;
                        } else {
                            this.aUS.aUa = true;
                        }
                        FrsActivity frsActivity2 = this.aUS;
                        wVar7 = this.aUS.aUg;
                        frsActivity2.a(wVar7);
                        bsVar = this.aUS.aUc;
                        bsVar.LZ();
                    }
                }
            }
        }
        return true;
    }
}
