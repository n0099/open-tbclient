package com.baidu.tieba.frs;

import com.baidu.tieba.frs.b.o;
import com.baidu.tieba.tbadkCore.e;
import java.util.ArrayList;
/* loaded from: classes.dex */
class a implements eb {
    final /* synthetic */ FrsActivity aUK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(FrsActivity frsActivity) {
        this.aUK = frsActivity;
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
                    bsVar7 = this.aUK.aTU;
                    bsVar7.Mc();
                } else if (eeVar.hasMore) {
                    bsVar11 = this.aUK.aTU;
                    bsVar11.Ma();
                } else if (eeVar.aZb) {
                    bsVar9 = this.aUK.aTU;
                    i5 = FrsActivity.aTE;
                    int size = arrayList.size();
                    i6 = FrsActivity.aTF;
                    bsVar9.fB(i5 - (size * i6));
                    bsVar10 = this.aUK.aTU;
                    bsVar10.Mb();
                } else {
                    bsVar8 = this.aUK.aTU;
                    bsVar8.Mc();
                }
            }
        } else {
            eeVar = new ee();
            eeVar.pn = 1;
            eeVar.hasMore = false;
            eeVar.aZb = false;
            if (arrayList != null) {
                bsVar = this.aUK.aTU;
                i3 = FrsActivity.aTE;
                int size2 = arrayList.size();
                i4 = FrsActivity.aTF;
                bsVar.fB(i3 - (size2 * i4));
            }
        }
        oVar = this.aUK.aUj;
        if (!oVar.Z(i, i2)) {
            aVar2 = this.aUK.aUk;
            if (aVar2.NF()) {
                o.a aVar5 = new o.a();
                aVar3 = this.aUK.aUk;
                if (aVar3.NH()) {
                    bsVar6 = this.aUK.aTU;
                    aVar5.bch = bsVar6.getListView().getHeaderViewsCount() - 2;
                } else {
                    bsVar5 = this.aUK.aTU;
                    aVar5.bch = bsVar5.getListView().getHeaderViewsCount() - 1;
                }
                aVar5.top = 0;
                oVar4 = this.aUK.aUj;
                oVar4.a(i, i2, aVar5);
            }
        }
        if (i == 1) {
            com.baidu.tieba.tbadkCore.r rVar = this.aUK.aUu;
            aVar = this.aUK.aUi;
            rVar.a(aVar.getType(), false, aVar4);
        } else {
            if (eeVar.errCode != 0 || arrayList == null || arrayList.size() == 0) {
                if (340001 == aVar4.errorCode) {
                    FrsActivity frsActivity = this.aUK;
                    bsVar3 = this.aUK.aTU;
                    frsActivity.showNetRefreshViewNoClick(bsVar3.getRootView(), aVar4.errorMsg, true);
                } else {
                    FrsActivity frsActivity2 = this.aUK;
                    bsVar2 = this.aUK.aTU;
                    frsActivity2.showNetRefreshView(bsVar2.getRootView(), aVar4.errorMsg, true);
                }
            }
            bsVar4 = this.aUK.aTU;
            bsVar4.cc(false);
            if (this.aUK.Li().MN() != null) {
                this.aUK.aTW = this.aUK.Li().MN();
            }
            this.aUK.KW();
        }
        oVar2 = this.aUK.aUj;
        if (oVar2.NM() != null) {
            oVar3 = this.aUK.aUj;
            oVar3.NM().a(i, i2, eeVar, arrayList);
        }
    }
}
