package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class t implements com.baidu.adp.widget.ListView.w {
    final /* synthetic */ FrsActivity aUK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(FrsActivity frsActivity) {
        this.aUK = frsActivity;
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
        if (bdUniqueId.getId() == com.baidu.tbadk.core.data.b.TO.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.TP.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.TQ.getId()) {
            this.aUK.aTY = (com.baidu.tbadk.core.data.w) uVar;
            wVar = this.aUK.aTY;
            if (wVar instanceof com.baidu.tbadk.core.data.b) {
                wVar2 = this.aUK.aTY;
                com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) wVar2;
                if (bVar.ro()) {
                    return false;
                }
                if (bVar.TU == 0) {
                    this.aUK.a(bVar, i);
                }
                TiebaStatic.eventStat(this.aUK.getPageContext().getPageActivity(), "frs_tb_arc", "");
            }
        } else if (bdUniqueId.getId() != com.baidu.tieba.tbadkCore.z.cYd.getId()) {
            if (bdUniqueId.getId() == com.baidu.tbadk.core.data.b.TR.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.TS.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.TT.getId()) {
                if (uVar instanceof com.baidu.tbadk.core.data.b) {
                    com.baidu.tbadk.core.data.b bVar2 = (com.baidu.tbadk.core.data.b) uVar;
                    if (bVar2.rn()) {
                        if (bVar2.TU == 0) {
                            this.aUK.a(bVar2, i);
                        }
                        TiebaStatic.eventStat(this.aUK.getPageContext().getPageActivity(), "frs_tb_arc", "");
                    }
                }
            } else if (uVar instanceof com.baidu.tbadk.core.data.w) {
                this.aUK.aTY = (com.baidu.tbadk.core.data.w) uVar;
                wVar3 = this.aUK.aTY;
                if (!wVar3.isPhotoLiveThread()) {
                    wVar4 = this.aUK.aTY;
                    if (!(wVar4 instanceof com.baidu.tbadk.core.data.q)) {
                        FrsActivity frsActivity = this.aUK;
                        wVar5 = this.aUK.aTY;
                        frsActivity.mThreadId = wVar5.getId();
                        wVar6 = this.aUK.aTY;
                        String si = wVar6.si();
                        if (si == null || si.equals("")) {
                            this.aUK.aTS = false;
                        } else {
                            this.aUK.aTS = true;
                        }
                        FrsActivity frsActivity2 = this.aUK;
                        wVar7 = this.aUK.aTY;
                        frsActivity2.a(wVar7);
                        bsVar = this.aUK.aTU;
                        bsVar.LJ();
                    }
                }
            }
        }
        return true;
    }
}
