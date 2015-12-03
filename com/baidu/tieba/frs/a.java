package com.baidu.tieba.frs;

import com.baidu.tieba.frs.b.o;
import com.baidu.tieba.tbadkCore.e;
import java.util.ArrayList;
/* loaded from: classes.dex */
class a implements eu {
    final /* synthetic */ FrsActivity bag;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(FrsActivity frsActivity) {
        this.bag = frsActivity;
    }

    @Override // com.baidu.tieba.frs.eu
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
                    this.bag.aZq.NT();
                } else if (eyVar.hasMore) {
                    this.bag.aZq.NR();
                } else if (eyVar.bfs) {
                    cd cdVar = this.bag.aZq;
                    i5 = FrsActivity.aZa;
                    int size = arrayList.size();
                    i6 = FrsActivity.aZb;
                    cdVar.gg(i5 - (size * i6));
                    this.bag.aZq.NS();
                } else {
                    this.bag.aZq.NT();
                }
            }
        } else {
            eyVar = new ey();
            eyVar.pn = 1;
            eyVar.hasMore = false;
            eyVar.bfs = false;
            if (arrayList != null) {
                cd cdVar2 = this.bag.aZq;
                i3 = FrsActivity.aZa;
                int size2 = arrayList.size();
                i4 = FrsActivity.aZb;
                cdVar2.gg(i3 - (size2 * i4));
            }
        }
        oVar = this.bag.aZE;
        if (!oVar.ad(i, i2)) {
            aVar = this.bag.aZF;
            if (aVar.PH()) {
                o.a aVar4 = new o.a();
                aVar2 = this.bag.aZF;
                if (aVar2.PJ()) {
                    aVar4.asj = this.bag.aZq.getListView().getHeaderViewsCount() - 2;
                } else {
                    aVar4.asj = this.bag.aZq.getListView().getHeaderViewsCount() - 1;
                }
                aVar4.top = 0;
                oVar4 = this.bag.aZE;
                oVar4.a(i, i2, aVar4);
            }
        }
        if (i == 1) {
            this.bag.aZC = false;
            this.bag.aZP.a(this.bag.aZD.getType(), false, aVar3);
            this.bag.aZC = true;
        } else {
            if (eyVar.errCode != 0 || arrayList == null || arrayList.size() == 0) {
                if (340001 == aVar3.errorCode) {
                    this.bag.showNetRefreshViewNoClick(this.bag.aZq.getRootView(), aVar3.errorMsg, true);
                } else {
                    this.bag.showNetRefreshView(this.bag.aZq.getRootView(), aVar3.errorMsg, true);
                }
            }
            this.bag.aZq.cr(false);
            if (this.bag.MX().OH() != null) {
                this.bag.aZs = this.bag.MX().OH();
            }
            this.bag.MM();
        }
        oVar2 = this.bag.aZE;
        if (oVar2.PO() != null) {
            oVar3 = this.bag.aZE;
            oVar3.PO().a(i, i2, eyVar, arrayList);
        }
    }
}
