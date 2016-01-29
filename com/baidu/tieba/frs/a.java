package com.baidu.tieba.frs;

import com.baidu.tieba.frs.c.o;
import com.baidu.tieba.tbadkCore.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
class a implements ff {
    final /* synthetic */ FrsActivity bgz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(FrsActivity frsActivity) {
        this.bgz = frsActivity;
    }

    @Override // com.baidu.tieba.frs.ff
    public void a(int i, int i2, fi fiVar, ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        int i3;
        int i4;
        com.baidu.tieba.frs.c.o oVar;
        com.baidu.tieba.frs.c.o oVar2;
        com.baidu.tieba.frs.c.o oVar3;
        com.baidu.tieba.frs.c.a aVar;
        com.baidu.tieba.frs.c.a aVar2;
        com.baidu.tieba.frs.c.o oVar4;
        int i5;
        int i6;
        d.a aVar3 = new d.a();
        if (fiVar != null) {
            aVar3.isSuccess = fiVar.errCode == 0;
            aVar3.errorCode = fiVar.errCode;
            aVar3.errorMsg = fiVar.errMsg;
            if (aVar3.isSuccess) {
                if (arrayList == null || arrayList.size() == 0) {
                    this.bgz.bfD.Qp();
                } else if (fiVar.hasMore) {
                    this.bgz.bfD.Qn();
                } else if (fiVar.bmf) {
                    cn cnVar = this.bgz.bfD;
                    i5 = FrsActivity.bfn;
                    int size = arrayList.size();
                    i6 = FrsActivity.bfo;
                    cnVar.gy(i5 - (size * i6));
                    this.bgz.bfD.Qo();
                } else {
                    this.bgz.bfD.Qp();
                }
            }
        } else {
            fiVar = new fi();
            fiVar.pn = 1;
            fiVar.hasMore = false;
            fiVar.bmf = false;
            if (arrayList != null) {
                cn cnVar2 = this.bgz.bfD;
                i3 = FrsActivity.bfn;
                int size2 = arrayList.size();
                i4 = FrsActivity.bfo;
                cnVar2.gy(i3 - (size2 * i4));
            }
        }
        oVar = this.bgz.bfR;
        if (!oVar.ad(i, i2)) {
            aVar = this.bgz.bfS;
            if (aVar.Sd()) {
                o.a aVar4 = new o.a();
                aVar2 = this.bgz.bfS;
                if (aVar2.Sf()) {
                    aVar4.auF = this.bgz.bfD.KM().getHeaderViewsCount() - 2;
                } else {
                    aVar4.auF = this.bgz.bfD.KM().getHeaderViewsCount() - 1;
                }
                aVar4.top = 0;
                oVar4 = this.bgz.bfR;
                oVar4.a(i, i2, aVar4);
            }
        }
        if (i == 1) {
            this.bgz.bfP = false;
            this.bgz.bgd.a(this.bgz.bfQ.getType(), false, aVar3);
            this.bgz.bfP = true;
        } else {
            if (fiVar.errCode != 0 || arrayList == null || arrayList.size() == 0) {
                if (340001 == aVar3.errorCode) {
                    this.bgz.showNetRefreshViewNoClick(this.bgz.bfD.getRootView(), aVar3.errorMsg, true);
                } else {
                    this.bgz.showNetRefreshView(this.bgz.bfD.getRootView(), aVar3.errorMsg, true);
                }
            }
            this.bgz.bfD.cs(false);
            if (this.bgz.Po().Rc() != null) {
                this.bgz.bfF = this.bgz.Po().Rc();
            }
            this.bgz.Pa();
        }
        oVar2 = this.bgz.bfR;
        if (oVar2.Sk() != null) {
            oVar3 = this.bgz.bfR;
            oVar3.Sk().a(i, i2, fiVar, arrayList);
        }
    }
}
