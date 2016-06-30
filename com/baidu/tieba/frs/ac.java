package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.b;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class ac implements com.baidu.adp.widget.ListView.x {
    final /* synthetic */ FrsActivity bDB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(FrsActivity frsActivity) {
        this.bDB = frsActivity;
    }

    @Override // com.baidu.adp.widget.ListView.x
    public boolean b(View view, com.baidu.adp.widget.ListView.v vVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        com.baidu.tbadk.core.data.az azVar;
        com.baidu.tbadk.core.data.az azVar2;
        com.baidu.tbadk.core.data.az azVar3;
        com.baidu.tbadk.core.data.az azVar4;
        com.baidu.tbadk.core.data.az azVar5;
        com.baidu.tbadk.core.data.az azVar6;
        com.baidu.tbadk.core.data.az azVar7;
        bq bqVar;
        if (bdUniqueId == null) {
            return false;
        }
        if (bdUniqueId.getId() == b.My.getId() || bdUniqueId.getId() == b.Mz.getId() || bdUniqueId.getId() == b.MA.getId()) {
            this.bDB.bCH = (com.baidu.tbadk.core.data.az) vVar;
            azVar = this.bDB.bCH;
            if (azVar instanceof b) {
                azVar2 = this.bDB.bCH;
                b bVar = (b) azVar2;
                if (bVar.ox()) {
                    return false;
                }
                if (bVar.MF == 0) {
                    this.bDB.a(bVar, i, true);
                }
                TiebaStatic.eventStat(this.bDB.getPageContext().getPageActivity(), "frs_tb_arc", "");
            }
        } else if (bdUniqueId.getId() != com.baidu.tieba.tbadkCore.ab.eWn.getId()) {
            if (bdUniqueId.getId() == b.MB.getId() || bdUniqueId.getId() == b.MC.getId() || bdUniqueId.getId() == b.MD.getId()) {
                if (vVar instanceof b) {
                    b bVar2 = (b) vVar;
                    if (bVar2.ow()) {
                        if (bVar2.MF == 0) {
                            this.bDB.a(bVar2, i, true);
                        }
                        TiebaStatic.eventStat(this.bDB.getPageContext().getPageActivity(), "frs_tb_arc", "");
                    }
                }
            } else if (vVar instanceof com.baidu.tbadk.core.data.az) {
                this.bDB.bCH = (com.baidu.tbadk.core.data.az) vVar;
                azVar3 = this.bDB.bCH;
                if (!azVar3.isPhotoLiveThread()) {
                    azVar4 = this.bDB.bCH;
                    if (!(azVar4 instanceof com.baidu.tbadk.core.data.ak)) {
                        FrsActivity frsActivity = this.bDB;
                        azVar5 = this.bDB.bCH;
                        frsActivity.mThreadId = azVar5.getId();
                        azVar6 = this.bDB.bCH;
                        String qN = azVar6.qN();
                        if (qN == null || qN.equals("")) {
                            this.bDB.bCB = false;
                        } else {
                            this.bDB.bCB = true;
                        }
                        FrsActivity frsActivity2 = this.bDB;
                        azVar7 = this.bDB.bCH;
                        frsActivity2.d(azVar7);
                        bqVar = this.bDB.bCD;
                        bqVar.Wj();
                    }
                }
            }
        }
        return true;
    }
}
