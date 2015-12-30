package com.baidu.tieba.frs;

import com.baidu.tieba.frs.b.o;
import com.baidu.tieba.tbadkCore.e;
import java.util.ArrayList;
/* loaded from: classes.dex */
class a implements ev {
    final /* synthetic */ FrsActivity bed;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(FrsActivity frsActivity) {
        this.bed = frsActivity;
    }

    @Override // com.baidu.tieba.frs.ev
    public void a(int i, int i2, ey eyVar, ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        int i3;
        int i4;
        com.baidu.tieba.frs.b.o oVar;
        com.baidu.tieba.frs.b.o oVar2;
        com.baidu.tieba.frs.b.o oVar3;
        com.baidu.tieba.frs.b.a aVar;
        com.baidu.tieba.frs.b.a aVar2;
        com.baidu.tieba.frs.b.o oVar4;
        int i5;
        int i6;
        e.a aVar3 = new e.a();
        if (eyVar != null) {
            aVar3.isSuccess = eyVar.errCode == 0;
            aVar3.errorCode = eyVar.errCode;
            aVar3.errorMsg = eyVar.errMsg;
            if (aVar3.isSuccess) {
                if (arrayList == null || arrayList.size() == 0) {
                    this.bed.bdm.Om();
                } else if (eyVar.hasMore) {
                    this.bed.bdm.Ok();
                } else if (eyVar.bjk) {
                    cg cgVar = this.bed.bdm;
                    i5 = FrsActivity.bcW;
                    int size = arrayList.size();
                    i6 = FrsActivity.bcX;
                    cgVar.gb(i5 - (size * i6));
                    this.bed.bdm.Ol();
                } else {
                    this.bed.bdm.Om();
                }
            }
        } else {
            eyVar = new ey();
            eyVar.pn = 1;
            eyVar.hasMore = false;
            eyVar.bjk = false;
            if (arrayList != null) {
                cg cgVar2 = this.bed.bdm;
                i3 = FrsActivity.bcW;
                int size2 = arrayList.size();
                i4 = FrsActivity.bcX;
                cgVar2.gb(i3 - (size2 * i4));
            }
        }
        oVar = this.bed.bdA;
        if (!oVar.ad(i, i2)) {
            aVar = this.bed.bdB;
            if (aVar.PZ()) {
                o.a aVar4 = new o.a();
                aVar2 = this.bed.bdB;
                if (aVar2.Qb()) {
                    aVar4.atN = this.bed.bdm.getListView().getHeaderViewsCount() - 2;
                } else {
                    aVar4.atN = this.bed.bdm.getListView().getHeaderViewsCount() - 1;
                }
                aVar4.top = 0;
                oVar4 = this.bed.bdA;
                oVar4.a(i, i2, aVar4);
            }
        }
        if (i == 1) {
            this.bed.bdy = false;
            this.bed.bdL.a(this.bed.bdz.getType(), false, aVar3);
            this.bed.bdy = true;
        } else {
            if (eyVar.errCode != 0 || arrayList == null || arrayList.size() == 0) {
                if (340001 == aVar3.errorCode) {
                    this.bed.showNetRefreshViewNoClick(this.bed.bdm.getRootView(), aVar3.errorMsg, true);
                } else {
                    this.bed.showNetRefreshView(this.bed.bdm.getRootView(), aVar3.errorMsg, true);
                }
            }
            this.bed.bdm.cs(false);
            if (this.bed.Nr().OZ() != null) {
                this.bed.bdo = this.bed.Nr().OZ();
            }
            this.bed.Ng();
        }
        oVar2 = this.bed.bdA;
        if (oVar2.Qg() != null) {
            oVar3 = this.bed.bdA;
            oVar3.Qg().a(i, i2, eyVar, arrayList);
        }
    }
}
