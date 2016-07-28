package com.baidu.tieba.frs;

import android.widget.AbsListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.b;
import com.baidu.tieba.frs.j.a;
/* loaded from: classes.dex */
class s implements AbsListView.OnScrollListener {
    final /* synthetic */ FrsActivity bEL;
    private int aLr = 0;
    private int aLq = 0;
    private com.baidu.tbadk.util.e<Boolean> bEN = new t(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(FrsActivity frsActivity) {
        this.bEL = frsActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        com.baidu.tieba.frs.entelechy.b.d dVar;
        a aVar;
        Cdo cdo;
        bq bqVar;
        bq bqVar2;
        bq bqVar3;
        com.baidu.tieba.tbadkCore.data.f fVar;
        bq bqVar4;
        com.baidu.tieba.tbadkCore.data.f fVar2;
        com.baidu.tieba.tbadkCore.data.f fVar3;
        int i4;
        boolean z;
        com.baidu.tieba.tbadkCore.data.f fVar4;
        int i5;
        boolean z2;
        Cdo cdo2;
        com.baidu.tieba.frs.j.p pVar;
        a aVar2;
        com.baidu.tieba.frs.entelechy.b.d dVar2;
        com.baidu.tieba.frs.j.p pVar2;
        dVar = this.bEL.bEc;
        if (dVar != null) {
            dVar2 = this.bEL.bEc;
            pVar2 = this.bEL.bDY;
            dVar2.a(absListView, i, i2, i3, pVar2.aaS());
        }
        aVar = this.bEL.bEl;
        if (aVar != null) {
            aVar2 = this.bEL.bEl;
            aVar2.aas();
        }
        cdo = this.bEL.bEf;
        if (cdo != null) {
            cdo2 = this.bEL.bEf;
            pVar = this.bEL.bDY;
            cdo2.a(absListView, i, i2, i3, pVar.aaS(), this.bEN);
        }
        if (this.bEL.bDM != null) {
            bqVar = this.bEL.bDK;
            if (bqVar != null) {
                bqVar2 = this.bEL.bDK;
                if (bqVar2.WN() != null) {
                    int bej = this.bEL.bDM.bej();
                    bqVar3 = this.bEL.bDK;
                    int headerViewsCount = ((i + i2) - bqVar3.getListView().getHeaderViewsCount()) - bej;
                    int i6 = (headerViewsCount - 1) + bej;
                    fVar = this.bEL.bDG;
                    if (fVar != null) {
                        fVar2 = this.bEL.bDG;
                        int qU = fVar2.qU(headerViewsCount);
                        if (qU >= 0 && i6 >= 0 && i6 < this.bEL.bDM.getThreadList().size()) {
                            com.baidu.adp.widget.ListView.v vVar = this.bEL.bDM.getThreadList().get(i6);
                            if (vVar instanceof b) {
                                fVar4 = this.bEL.bDG;
                                fVar4.c(headerViewsCount, 1, this.bEL.forumId, qU);
                                i5 = this.bEL.mPn;
                                com.baidu.tieba.recapp.report.a a = com.baidu.tieba.recapp.report.e.a((b) vVar, "show", i5);
                                z2 = this.bEL.bDF;
                                a.bL("isCache", String.valueOf(z2));
                                com.baidu.tieba.recapp.report.b.aYc().a(a);
                            } else {
                                ForumData aGX = this.bEL.bDM.aGX();
                                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                                fVar3 = this.bEL.bDG;
                                fVar3.c(headerViewsCount, 2, this.bEL.forumId, qU);
                                i4 = this.bEL.mPn;
                                com.baidu.tieba.recapp.report.a i7 = com.baidu.tieba.recapp.report.e.i("store", qU, i4);
                                i7.bL("page", "FRS");
                                z = this.bEL.bDF;
                                i7.bL("isCache", String.valueOf(z));
                                if (aGX != null) {
                                    i7.bL("fid", aGX.getId());
                                    i7.bL("fc1", aGX.getFirst_class());
                                    i7.bL("fc2", aGX.getSecond_class());
                                }
                                if (currentAccountObj != null) {
                                    i7.bL("vc", String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
                                }
                                com.baidu.tieba.recapp.report.b.aYc().a(i7);
                            }
                        }
                    }
                    this.aLr = i;
                    this.aLq = (i + i2) - 1;
                    bqVar4 = this.bEL.bDK;
                    bqVar4.ab(this.aLr, this.aLq);
                }
            }
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        com.baidu.tieba.frs.j.p pVar;
        Cdo cdo;
        boolean z;
        bq bqVar;
        bq bqVar2;
        bq bqVar3;
        com.baidu.adp.widget.ListView.x xVar;
        bq bqVar4;
        Cdo cdo2;
        com.baidu.tieba.frs.j.p pVar2;
        pVar = this.bEL.bDY;
        if (pVar != null) {
            pVar2 = this.bEL.bDY;
            pVar2.setScrollState(i);
        }
        cdo = this.bEL.bEf;
        if (cdo != null) {
            cdo2 = this.bEL.bEf;
            cdo2.onScrollStateChanged(absListView, i);
        }
        if (i == 2 || i == 1) {
            z = this.bEL.bDT;
            if (!z) {
                this.bEL.bDT = true;
                bqVar = this.bEL.bDK;
                bqVar.WP();
            }
        }
        if (this.bEL.bDU == null) {
            this.bEL.bDU = new com.baidu.tbadk.performanceLog.e();
            this.bEL.bDU.eQ(1000);
        }
        com.baidu.tbadk.core.view.at.vG().aL(i == 0);
        if (i != 0) {
            bqVar2 = this.bEL.bDK;
            bqVar2.a((com.baidu.adp.widget.ListView.x) null);
        } else {
            com.baidu.tieba.card.bw.Lf().cm(true);
            bqVar3 = this.bEL.bDK;
            xVar = this.bEL.bEH;
            bqVar3.a(xVar);
            bqVar4 = this.bEL.bDK;
            bqVar4.aa(this.aLr, this.aLq);
        }
        this.bEL.bDU.EC();
    }
}
