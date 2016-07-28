package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.b;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class ac implements com.baidu.adp.widget.ListView.x {
    final /* synthetic */ FrsActivity bEL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(FrsActivity frsActivity) {
        this.bEL = frsActivity;
    }

    @Override // com.baidu.adp.widget.ListView.x
    public boolean b(View view, com.baidu.adp.widget.ListView.v vVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        com.baidu.tbadk.core.data.be beVar;
        com.baidu.tbadk.core.data.be beVar2;
        com.baidu.tbadk.core.data.be beVar3;
        com.baidu.tbadk.core.data.be beVar4;
        com.baidu.tbadk.core.data.be beVar5;
        com.baidu.tbadk.core.data.be beVar6;
        com.baidu.tbadk.core.data.be beVar7;
        bq bqVar;
        if (bdUniqueId == null) {
            return false;
        }
        if (bdUniqueId.getId() == b.Mw.getId() || bdUniqueId.getId() == b.Mx.getId() || bdUniqueId.getId() == b.My.getId()) {
            this.bEL.bDO = (com.baidu.tbadk.core.data.be) vVar;
            beVar = this.bEL.bDO;
            if (beVar instanceof b) {
                beVar2 = this.bEL.bDO;
                b bVar = (b) beVar2;
                if (bVar.om()) {
                    return false;
                }
                if (bVar.MD == 0) {
                    this.bEL.a(bVar, i, true);
                }
                TiebaStatic.eventStat(this.bEL.getPageContext().getPageActivity(), "frs_tb_arc", "");
            }
        } else if (bdUniqueId.getId() != com.baidu.tieba.tbadkCore.ab.fjp.getId()) {
            if (bdUniqueId.getId() == b.Mz.getId() || bdUniqueId.getId() == b.MA.getId() || bdUniqueId.getId() == b.MB.getId()) {
                if (vVar instanceof b) {
                    b bVar2 = (b) vVar;
                    if (bVar2.ol()) {
                        if (bVar2.MD == 0) {
                            this.bEL.a(bVar2, i, true);
                        }
                        TiebaStatic.eventStat(this.bEL.getPageContext().getPageActivity(), "frs_tb_arc", "");
                    }
                }
            } else if (vVar instanceof com.baidu.tbadk.core.data.be) {
                this.bEL.bDO = (com.baidu.tbadk.core.data.be) vVar;
                beVar3 = this.bEL.bDO;
                if (!beVar3.isPhotoLiveThread()) {
                    beVar4 = this.bEL.bDO;
                    if (!(beVar4 instanceof com.baidu.tbadk.core.data.ap)) {
                        FrsActivity frsActivity = this.bEL;
                        beVar5 = this.bEL.bDO;
                        frsActivity.mThreadId = beVar5.getId();
                        beVar6 = this.bEL.bDO;
                        String qC = beVar6.qC();
                        if (qC == null || qC.equals("")) {
                            this.bEL.bDI = false;
                        } else {
                            this.bEL.bDI = true;
                        }
                        FrsActivity frsActivity2 = this.bEL;
                        beVar7 = this.bEL.bDO;
                        frsActivity2.d(beVar7);
                        bqVar = this.bEL.bDK;
                        bqVar.WA();
                    }
                }
            }
        }
        return true;
    }
}
