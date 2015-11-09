package com.baidu.tieba.frs;

import com.baidu.tieba.frs.b.o;
import com.baidu.tieba.tbadkCore.e;
import java.util.ArrayList;
/* loaded from: classes.dex */
class a implements ed {
    final /* synthetic */ FrsActivity aUS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(FrsActivity frsActivity) {
        this.aUS = frsActivity;
    }

    @Override // com.baidu.tieba.frs.ed
    public void a(int i, int i2, eg egVar, ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
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
        if (egVar != null) {
            aVar4.isSuccess = egVar.errCode == 0;
            aVar4.errorCode = egVar.errCode;
            aVar4.errorMsg = egVar.errMsg;
            if (aVar4.isSuccess) {
                if (arrayList == null || arrayList.size() == 0) {
                    bsVar7 = this.aUS.aUc;
                    bsVar7.Ms();
                } else if (egVar.hasMore) {
                    bsVar11 = this.aUS.aUc;
                    bsVar11.Mq();
                } else if (egVar.aZn) {
                    bsVar9 = this.aUS.aUc;
                    i5 = FrsActivity.aTM;
                    int size = arrayList.size();
                    i6 = FrsActivity.aTN;
                    bsVar9.fJ(i5 - (size * i6));
                    bsVar10 = this.aUS.aUc;
                    bsVar10.Mr();
                } else {
                    bsVar8 = this.aUS.aUc;
                    bsVar8.Ms();
                }
            }
        } else {
            egVar = new eg();
            egVar.pn = 1;
            egVar.hasMore = false;
            egVar.aZn = false;
            if (arrayList != null) {
                bsVar = this.aUS.aUc;
                i3 = FrsActivity.aTM;
                int size2 = arrayList.size();
                i4 = FrsActivity.aTN;
                bsVar.fJ(i3 - (size2 * i4));
            }
        }
        oVar = this.aUS.aUr;
        if (!oVar.ab(i, i2)) {
            aVar2 = this.aUS.aUs;
            if (aVar2.Ob()) {
                o.a aVar5 = new o.a();
                aVar3 = this.aUS.aUs;
                if (aVar3.Od()) {
                    bsVar6 = this.aUS.aUc;
                    aVar5.bcM = bsVar6.getListView().getHeaderViewsCount() - 2;
                } else {
                    bsVar5 = this.aUS.aUc;
                    aVar5.bcM = bsVar5.getListView().getHeaderViewsCount() - 1;
                }
                aVar5.top = 0;
                oVar4 = this.aUS.aUr;
                oVar4.a(i, i2, aVar5);
            }
        }
        if (i == 1) {
            this.aUS.aUp = false;
            com.baidu.tieba.tbadkCore.r rVar = this.aUS.aUC;
            aVar = this.aUS.aUq;
            rVar.a(aVar.getType(), false, aVar4);
            this.aUS.aUp = true;
        } else {
            if (egVar.errCode != 0 || arrayList == null || arrayList.size() == 0) {
                if (340001 == aVar4.errorCode) {
                    FrsActivity frsActivity = this.aUS;
                    bsVar3 = this.aUS.aUc;
                    frsActivity.showNetRefreshViewNoClick(bsVar3.getRootView(), aVar4.errorMsg, true);
                } else {
                    FrsActivity frsActivity2 = this.aUS;
                    bsVar2 = this.aUS.aUc;
                    frsActivity2.showNetRefreshView(bsVar2.getRootView(), aVar4.errorMsg, true);
                }
            }
            bsVar4 = this.aUS.aUc;
            bsVar4.ce(false);
            if (this.aUS.Ly().Nf() != null) {
                this.aUS.aUe = this.aUS.Ly().Nf();
            }
            this.aUS.Lm();
        }
        oVar2 = this.aUS.aUr;
        if (oVar2.Oi() != null) {
            oVar3 = this.aUS.aUr;
            oVar3.Oi().a(i, i2, egVar, arrayList);
        }
    }
}
