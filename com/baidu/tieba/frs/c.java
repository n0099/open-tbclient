package com.baidu.tieba.frs;

import com.baidu.tieba.frs.entelechy.b.b;
import com.baidu.tieba.tbadkCore.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
class c implements fi {
    final /* synthetic */ FrsActivity bhl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(FrsActivity frsActivity) {
        this.bhl = frsActivity;
    }

    @Override // com.baidu.tieba.frs.fi
    public void a(int i, int i2, fq fqVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        cn cnVar;
        b bVar;
        cn cnVar2;
        int i3;
        int i4;
        cn cnVar3;
        cn cnVar4;
        cn cnVar5;
        com.baidu.tieba.frs.h.aa aaVar;
        com.baidu.tieba.frs.h.aa aaVar2;
        cn cnVar6;
        cn cnVar7;
        cn cnVar8;
        int i5;
        int i6;
        cn cnVar9;
        cn cnVar10;
        com.baidu.tieba.frs.h.m mVar;
        b bVar2;
        cn cnVar11;
        cnVar = this.bhl.bgo;
        if (cnVar.QC() instanceof com.baidu.tieba.frs.tab.h) {
            cnVar11 = this.bhl.bgo;
            ((com.baidu.tieba.frs.tab.h) cnVar11.QC()).Pn();
        }
        bVar = this.bhl.bgN;
        if (bVar != null) {
            mVar = this.bhl.bgE;
            bVar2 = this.bhl.bgN;
            mVar.dl(bVar2.gx(i));
        }
        d.a aVar = new d.a();
        if (fqVar != null) {
            aVar.isSuccess = fqVar.errCode == 0;
            aVar.errorCode = fqVar.errCode;
            aVar.errorMsg = fqVar.errMsg;
            if (aVar.isSuccess) {
                if (arrayList == null || arrayList.size() == 0) {
                    cnVar6 = this.bhl.bgo;
                    cnVar6.Ri();
                } else if (fqVar.hasMore) {
                    cnVar10 = this.bhl.bgo;
                    cnVar10.Rg();
                } else if (fqVar.bmV) {
                    cnVar8 = this.bhl.bgo;
                    i5 = FrsActivity.bfW;
                    int size = arrayList.size();
                    i6 = FrsActivity.bfX;
                    cnVar8.gq(i5 - (size * i6));
                    cnVar9 = this.bhl.bgo;
                    cnVar9.Rh();
                } else {
                    cnVar7 = this.bhl.bgo;
                    cnVar7.Ri();
                }
            }
        } else {
            fqVar = new fq();
            fqVar.pn = 1;
            fqVar.hasMore = false;
            fqVar.bmV = false;
            if (arrayList != null) {
                cnVar2 = this.bhl.bgo;
                i3 = FrsActivity.bfW;
                int size2 = arrayList.size();
                i4 = FrsActivity.bfX;
                cnVar2.gq(i3 - (size2 * i4));
            }
        }
        if (i == 1) {
            this.bhl.bgB = true;
            this.bhl.bgU.a(this.bhl.bgC.getType(), false, aVar);
        } else {
            if (fqVar.errCode != 0 || arrayList == null || arrayList.size() == 0) {
                if (340001 == aVar.errorCode) {
                    FrsActivity frsActivity = this.bhl;
                    cnVar4 = this.bhl.bgo;
                    frsActivity.showNetRefreshViewNoClick(cnVar4.getRootView(), aVar.errorMsg, true);
                } else {
                    FrsActivity frsActivity2 = this.bhl;
                    cnVar3 = this.bhl.bgo;
                    frsActivity2.showNetRefreshView(cnVar3.getRootView(), aVar.errorMsg, true);
                }
                this.bhl.setNetRefreshViewEmotionDefMarginTop();
            }
            this.bhl.PN();
            if (this.bhl.Qd().Tc() != null) {
                this.bhl.bgq = this.bhl.Qd().Tc();
            }
            cnVar5 = this.bhl.bgo;
            cnVar5.cQ(false);
        }
        aaVar = this.bhl.bgD;
        if (aaVar.Uc() != null) {
            aaVar2 = this.bhl.bgD;
            aaVar2.Uc().a(i, i2, fqVar, arrayList);
        }
    }
}
