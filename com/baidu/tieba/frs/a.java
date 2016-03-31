package com.baidu.tieba.frs;

import com.baidu.tieba.frs.c.o;
import com.baidu.tieba.tbadkCore.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
class a implements fp {
    final /* synthetic */ FrsActivity blk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(FrsActivity frsActivity) {
        this.blk = frsActivity;
    }

    @Override // com.baidu.tieba.frs.fp
    public void a(int i, int i2, fr frVar, ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
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
        if (frVar != null) {
            aVar3.isSuccess = frVar.errCode == 0;
            aVar3.errorCode = frVar.errCode;
            aVar3.errorMsg = frVar.errMsg;
            if (aVar3.isSuccess) {
                if (arrayList == null || arrayList.size() == 0) {
                    this.blk.bko.Si();
                } else if (frVar.hasMore) {
                    this.blk.bko.Sg();
                } else if (frVar.bru) {
                    cs csVar = this.blk.bko;
                    i5 = FrsActivity.bjX;
                    int size = arrayList.size();
                    i6 = FrsActivity.bjY;
                    csVar.gP(i5 - (size * i6));
                    this.blk.bko.Sh();
                } else {
                    this.blk.bko.Si();
                }
            }
        } else {
            frVar = new fr();
            frVar.pn = 1;
            frVar.hasMore = false;
            frVar.bru = false;
            if (arrayList != null) {
                cs csVar2 = this.blk.bko;
                i3 = FrsActivity.bjX;
                int size2 = arrayList.size();
                i4 = FrsActivity.bjY;
                csVar2.gP(i3 - (size2 * i4));
            }
        }
        oVar = this.blk.bkC;
        if (!oVar.aa(i, i2)) {
            aVar = this.blk.bkD;
            if (aVar.TR()) {
                o.a aVar4 = new o.a();
                aVar2 = this.blk.bkD;
                if (aVar2.TU()) {
                    aVar4.avf = this.blk.bko.Mg().getHeaderViewsCount() - 2;
                } else {
                    aVar4.avf = this.blk.bko.Mg().getHeaderViewsCount() - 1;
                }
                aVar4.top = 0;
                oVar4 = this.blk.bkC;
                oVar4.a(i, i2, aVar4);
            }
        }
        if (i == 1) {
            this.blk.bkA = false;
            this.blk.bkP.a(this.blk.bkB.getType(), false, aVar3);
            this.blk.bkA = true;
        } else {
            if (frVar.errCode != 0 || arrayList == null || arrayList.size() == 0) {
                if (340001 == aVar3.errorCode) {
                    this.blk.showNetRefreshViewNoClick(this.blk.bko.getRootView(), aVar3.errorMsg, true);
                } else {
                    this.blk.showNetRefreshView(this.blk.bko.getRootView(), aVar3.errorMsg, true);
                }
            }
            this.blk.bko.cE(false);
            if (this.blk.Rd().SP() != null) {
                this.blk.bkq = this.blk.Rd().SP();
            }
            this.blk.QP();
        }
        oVar2 = this.blk.bkC;
        if (oVar2.TZ() != null) {
            oVar3 = this.blk.bkC;
            oVar3.TZ().a(i, i2, frVar, arrayList);
        }
    }
}
