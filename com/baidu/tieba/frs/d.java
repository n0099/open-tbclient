package com.baidu.tieba.frs;

import com.baidu.tieba.frs.entelechy.b.b;
import com.baidu.tieba.tbadkCore.e;
import java.util.ArrayList;
/* loaded from: classes.dex */
class d implements dm {
    final /* synthetic */ FrsActivity bEL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(FrsActivity frsActivity) {
        this.bEL = frsActivity;
    }

    @Override // com.baidu.tieba.frs.dm
    public void a(int i, int i2, dv dvVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        bq bqVar;
        b bVar;
        bq bqVar2;
        bq bqVar3;
        bq bqVar4;
        bq bqVar5;
        dm dmVar;
        dm dmVar2;
        bq bqVar6;
        bq bqVar7;
        bq bqVar8;
        bq bqVar9;
        com.baidu.tieba.frs.j.p pVar;
        b bVar2;
        bq bqVar10;
        bqVar = this.bEL.bDK;
        if (bqVar.Wr() instanceof com.baidu.tieba.frs.tab.h) {
            bqVar10 = this.bEL.bDK;
            ((com.baidu.tieba.frs.tab.h) bqVar10.Wr()).aap();
        }
        bVar = this.bEL.bEi;
        if (bVar != null) {
            pVar = this.bEL.bDY;
            bVar2 = this.bEL.bEi;
            pVar.dK(bVar2.hy(i));
        }
        e.a aVar = new e.a();
        if (dvVar != null) {
            aVar.isSuccess = dvVar.errCode == 0;
            aVar.errorCode = dvVar.errCode;
            aVar.errorMsg = dvVar.errMsg;
            if (aVar.isSuccess) {
                if (arrayList == null || arrayList.size() == 0) {
                    bqVar6 = this.bEL.bDK;
                    bqVar6.WT();
                } else if (dvVar.hasMore) {
                    bqVar9 = this.bEL.bDK;
                    bqVar9.WR();
                } else if (dvVar.bIG) {
                    bqVar8 = this.bEL.bDK;
                    bqVar8.WS();
                } else {
                    bqVar7 = this.bEL.bDK;
                    bqVar7.WT();
                }
            }
        } else {
            dvVar = new dv();
            dvVar.pn = 1;
            dvVar.hasMore = false;
            dvVar.bIG = false;
        }
        if (i == 1) {
            this.bEL.bDW = true;
            this.bEL.bEs.a(this.bEL.bDX.getType(), false, aVar);
        } else {
            if (dvVar.errCode != 0 || arrayList == null || arrayList.size() == 0) {
                if (340001 == aVar.errorCode) {
                    FrsActivity frsActivity = this.bEL;
                    bqVar3 = this.bEL.bDK;
                    frsActivity.showNetRefreshViewNoClick(bqVar3.getRootView(), aVar.errorMsg, true);
                } else {
                    FrsActivity frsActivity2 = this.bEL;
                    bqVar2 = this.bEL.bDK;
                    frsActivity2.showNetRefreshView(bqVar2.getRootView(), aVar.errorMsg, true);
                }
                this.bEL.setNetRefreshViewEmotionDefMarginTop();
            }
            this.bEL.VK();
            bqVar4 = this.bEL.bDK;
            bqVar4.getListView().jz();
            if (this.bEL.VY().Zj() != null) {
                this.bEL.bDM = this.bEL.VY().Zj();
            }
            bqVar5 = this.bEL.bDK;
            bqVar5.dj(false);
        }
        dmVar = this.bEL.bEK;
        if (dmVar == null) {
            return;
        }
        dmVar2 = this.bEL.bEK;
        dmVar2.a(i, i2, dvVar, arrayList);
    }
}
