package com.baidu.tieba.frs;

import com.baidu.tieba.frs.b.o;
import com.baidu.tieba.tbadkCore.e;
import java.util.ArrayList;
/* loaded from: classes.dex */
class a implements eb {
    final /* synthetic */ FrsActivity aUz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(FrsActivity frsActivity) {
        this.aUz = frsActivity;
    }

    @Override // com.baidu.tieba.frs.eb
    public void a(int i, int i2, ee eeVar, ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        bs bsVar;
        int i3;
        int i4;
        com.baidu.tieba.frs.b.o oVar;
        bs bsVar2;
        bs bsVar3;
        bs bsVar4;
        com.baidu.tieba.frs.b.o oVar2;
        com.baidu.tieba.frs.b.o oVar3;
        com.baidu.tieba.frs.mc.a aVar;
        com.baidu.tieba.frs.b.a aVar2;
        com.baidu.tieba.frs.b.a aVar3;
        bs bsVar5;
        com.baidu.tieba.frs.b.o oVar4;
        bs bsVar6;
        bs bsVar7;
        bs bsVar8;
        bs bsVar9;
        int i5;
        int i6;
        bs bsVar10;
        bs bsVar11;
        e.a aVar4 = new e.a();
        if (eeVar != null) {
            aVar4.isSuccess = eeVar.errCode == 0;
            aVar4.errorCode = eeVar.errCode;
            aVar4.errorMsg = eeVar.errMsg;
            if (aVar4.isSuccess) {
                if (arrayList == null || arrayList.size() == 0) {
                    bsVar7 = this.aUz.aTJ;
                    bsVar7.Mg();
                } else if (eeVar.hasMore) {
                    bsVar11 = this.aUz.aTJ;
                    bsVar11.Me();
                } else if (eeVar.aYQ) {
                    bsVar9 = this.aUz.aTJ;
                    i5 = FrsActivity.aTt;
                    int size = arrayList.size();
                    i6 = FrsActivity.aTu;
                    bsVar9.fB(i5 - (size * i6));
                    bsVar10 = this.aUz.aTJ;
                    bsVar10.Mf();
                } else {
                    bsVar8 = this.aUz.aTJ;
                    bsVar8.Mg();
                }
            }
        } else {
            eeVar = new ee();
            eeVar.pn = 1;
            eeVar.hasMore = false;
            eeVar.aYQ = false;
            if (arrayList != null) {
                bsVar = this.aUz.aTJ;
                i3 = FrsActivity.aTt;
                int size2 = arrayList.size();
                i4 = FrsActivity.aTu;
                bsVar.fB(i3 - (size2 * i4));
            }
        }
        oVar = this.aUz.aTY;
        if (!oVar.Z(i, i2)) {
            aVar2 = this.aUz.aTZ;
            if (aVar2.NJ()) {
                o.a aVar5 = new o.a();
                aVar3 = this.aUz.aTZ;
                if (aVar3.NL()) {
                    bsVar6 = this.aUz.aTJ;
                    aVar5.bbW = bsVar6.getListView().getHeaderViewsCount() - 2;
                } else {
                    bsVar5 = this.aUz.aTJ;
                    aVar5.bbW = bsVar5.getListView().getHeaderViewsCount() - 1;
                }
                aVar5.top = 0;
                oVar4 = this.aUz.aTY;
                oVar4.a(i, i2, aVar5);
            }
        }
        if (i == 1) {
            com.baidu.tieba.tbadkCore.r rVar = this.aUz.aUj;
            aVar = this.aUz.aTX;
            rVar.a(aVar.getType(), false, aVar4);
        } else {
            if (eeVar.errCode != 0 || arrayList == null || arrayList.size() == 0) {
                if (340001 == aVar4.errorCode) {
                    FrsActivity frsActivity = this.aUz;
                    bsVar3 = this.aUz.aTJ;
                    frsActivity.showNetRefreshViewNoClick(bsVar3.getRootView(), aVar4.errorMsg, true);
                } else {
                    FrsActivity frsActivity2 = this.aUz;
                    bsVar2 = this.aUz.aTJ;
                    frsActivity2.showNetRefreshView(bsVar2.getRootView(), aVar4.errorMsg, true);
                }
            }
            bsVar4 = this.aUz.aTJ;
            bsVar4.cc(false);
            if (this.aUz.Lm().MR() != null) {
                this.aUz.aTL = this.aUz.Lm().MR();
            }
            this.aUz.La();
        }
        oVar2 = this.aUz.aTY;
        if (oVar2.NQ() != null) {
            oVar3 = this.aUz.aTY;
            oVar3.NQ().a(i, i2, eeVar, arrayList);
        }
    }
}
