package com.baidu.tieba.frs;

import com.baidu.tieba.frs.entelechy.b.b;
import com.baidu.tieba.tbadkCore.e;
import java.util.ArrayList;
/* loaded from: classes.dex */
class d implements dm {
    final /* synthetic */ FrsActivity bDB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(FrsActivity frsActivity) {
        this.bDB = frsActivity;
    }

    @Override // com.baidu.tieba.frs.dm
    public void a(int i, int i2, dv dvVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        bq bqVar;
        b bVar;
        bq bqVar2;
        int i3;
        int i4;
        bq bqVar3;
        bq bqVar4;
        bq bqVar5;
        bq bqVar6;
        dm dmVar;
        dm dmVar2;
        bq bqVar7;
        bq bqVar8;
        bq bqVar9;
        int i5;
        int i6;
        bq bqVar10;
        bq bqVar11;
        com.baidu.tieba.frs.i.p pVar;
        b bVar2;
        bq bqVar12;
        bqVar = this.bDB.bCD;
        if (bqVar.Wa() instanceof com.baidu.tieba.frs.tab.h) {
            bqVar12 = this.bDB.bCD;
            ((com.baidu.tieba.frs.tab.h) bqVar12.Wa()).US();
        }
        bVar = this.bDB.bDb;
        if (bVar != null) {
            pVar = this.bDB.bCR;
            bVar2 = this.bDB.bDb;
            pVar.dK(bVar2.hz(i));
        }
        e.a aVar = new e.a();
        if (dvVar != null) {
            aVar.isSuccess = dvVar.errCode == 0;
            aVar.errorCode = dvVar.errCode;
            aVar.errorMsg = dvVar.errMsg;
            if (aVar.isSuccess) {
                if (arrayList == null || arrayList.size() == 0) {
                    bqVar7 = this.bDB.bCD;
                    bqVar7.WC();
                } else if (dvVar.hasMore) {
                    bqVar11 = this.bDB.bCD;
                    bqVar11.WA();
                } else if (dvVar.bHk) {
                    bqVar9 = this.bDB.bCD;
                    i5 = FrsActivity.bCl;
                    int size = arrayList.size();
                    i6 = FrsActivity.bCm;
                    bqVar9.hp(i5 - (size * i6));
                    bqVar10 = this.bDB.bCD;
                    bqVar10.WB();
                } else {
                    bqVar8 = this.bDB.bCD;
                    bqVar8.WC();
                }
            }
        } else {
            dvVar = new dv();
            dvVar.pn = 1;
            dvVar.hasMore = false;
            dvVar.bHk = false;
            if (arrayList != null) {
                bqVar2 = this.bDB.bCD;
                i3 = FrsActivity.bCl;
                int size2 = arrayList.size();
                i4 = FrsActivity.bCm;
                bqVar2.hp(i3 - (size2 * i4));
            }
        }
        if (i == 1) {
            this.bDB.bCP = true;
            this.bDB.bDl.a(this.bDB.bCQ.getType(), false, aVar);
        } else {
            if (dvVar.errCode != 0 || arrayList == null || arrayList.size() == 0) {
                if (340001 == aVar.errorCode) {
                    FrsActivity frsActivity = this.bDB;
                    bqVar4 = this.bDB.bCD;
                    frsActivity.showNetRefreshViewNoClick(bqVar4.getRootView(), aVar.errorMsg, true);
                } else {
                    FrsActivity frsActivity2 = this.bDB;
                    bqVar3 = this.bDB.bCD;
                    frsActivity2.showNetRefreshView(bqVar3.getRootView(), aVar.errorMsg, true);
                }
                this.bDB.setNetRefreshViewEmotionDefMarginTop();
            }
            this.bDB.Vt();
            bqVar5 = this.bDB.bCD;
            bqVar5.getListView().jA();
            if (this.bDB.VG().YO() != null) {
                this.bDB.bCF = this.bDB.VG().YO();
            }
            bqVar6 = this.bDB.bCD;
            bqVar6.dm(false);
        }
        dmVar = this.bDB.bDA;
        if (dmVar == null) {
            return;
        }
        dmVar2 = this.bDB.bDA;
        dmVar2.a(i, i2, dvVar, arrayList);
    }
}
