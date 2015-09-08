package com.baidu.tieba.frs;

import com.baidu.tieba.frs.c.n;
import com.baidu.tieba.tbadkCore.e;
import java.util.ArrayList;
/* loaded from: classes.dex */
class a implements di {
    final /* synthetic */ FrsActivity aVz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(FrsActivity frsActivity) {
        this.aVz = frsActivity;
    }

    @Override // com.baidu.tieba.frs.di
    public void a(int i, int i2, dl dlVar, ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        bi biVar;
        int i3;
        int i4;
        com.baidu.tieba.frs.c.n nVar;
        bi biVar2;
        bi biVar3;
        bi biVar4;
        com.baidu.tieba.frs.c.n nVar2;
        com.baidu.tieba.frs.c.n nVar3;
        com.baidu.tieba.frs.b.a aVar;
        com.baidu.tieba.frs.c.a aVar2;
        com.baidu.tieba.frs.c.a aVar3;
        bi biVar5;
        com.baidu.tieba.frs.c.n nVar4;
        bi biVar6;
        bi biVar7;
        bi biVar8;
        bi biVar9;
        int i5;
        int i6;
        bi biVar10;
        bi biVar11;
        e.a aVar4 = new e.a();
        if (dlVar != null) {
            aVar4.isSuccess = dlVar.errCode == 0;
            aVar4.errorCode = dlVar.errCode;
            aVar4.errorMsg = dlVar.errMsg;
            if (arrayList == null || arrayList.size() == 0) {
                biVar7 = this.aVz.aUL;
                biVar7.Mh();
            } else if (dlVar.hasMore) {
                biVar11 = this.aVz.aUL;
                biVar11.Mf();
            } else if (dlVar.aZb) {
                biVar9 = this.aVz.aUL;
                i5 = FrsActivity.aUx;
                int size = arrayList.size();
                i6 = FrsActivity.aUy;
                biVar9.fw(i5 - (size * i6));
                biVar10 = this.aVz.aUL;
                biVar10.Mg();
            } else {
                biVar8 = this.aVz.aUL;
                biVar8.Mh();
            }
        } else {
            dlVar = new dl();
            dlVar.pn = 1;
            dlVar.hasMore = false;
            dlVar.aZb = false;
            if (arrayList != null) {
                biVar = this.aVz.aUL;
                i3 = FrsActivity.aUx;
                int size2 = arrayList.size();
                i4 = FrsActivity.aUy;
                biVar.fw(i3 - (size2 * i4));
            }
        }
        nVar = this.aVz.aVa;
        if (!nVar.Z(i, i2)) {
            aVar2 = this.aVz.aVb;
            if (aVar2.NJ()) {
                n.a aVar5 = new n.a();
                aVar3 = this.aVz.aVb;
                if (aVar3.NL()) {
                    biVar6 = this.aVz.aUL;
                    aVar5.bcc = biVar6.getListView().getHeaderViewsCount() - 2;
                } else {
                    biVar5 = this.aVz.aUL;
                    aVar5.bcc = biVar5.getListView().getHeaderViewsCount() - 1;
                }
                aVar5.top = 0;
                nVar4 = this.aVz.aVa;
                nVar4.a(i, i2, aVar5);
            }
        }
        if (i == 1) {
            com.baidu.tieba.tbadkCore.r rVar = this.aVz.aVj;
            aVar = this.aVz.aUZ;
            rVar.a(aVar.getType(), false, aVar4);
        } else {
            if (dlVar.errCode != 0 || arrayList == null || arrayList.size() == 0) {
                if (340001 == aVar4.errorCode) {
                    FrsActivity frsActivity = this.aVz;
                    biVar3 = this.aVz.aUL;
                    frsActivity.showNetRefreshViewNoClick(biVar3.getRootView(), aVar4.errorMsg, true);
                } else {
                    FrsActivity frsActivity2 = this.aVz;
                    biVar2 = this.aVz.aUL;
                    frsActivity2.showNetRefreshView(biVar2.getRootView(), aVar4.errorMsg, true);
                }
            }
            biVar4 = this.aVz.aUL;
            biVar4.cf(false);
            if (this.aVz.Lq().MS() != null) {
                this.aVz.aUN = this.aVz.Lq().MS();
            }
            this.aVz.Le();
        }
        nVar2 = this.aVz.aVa;
        if (nVar2.NQ() != null) {
            nVar3 = this.aVz.aVa;
            nVar3.NQ().a(i, i2, dlVar, arrayList);
        }
    }
}
