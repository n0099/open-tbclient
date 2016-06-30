package com.baidu.tieba.frs;

import android.widget.AbsListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.b;
import com.baidu.tieba.frs.i.a;
/* loaded from: classes.dex */
class s implements AbsListView.OnScrollListener {
    final /* synthetic */ FrsActivity bDB;
    private int aKy = 0;
    private int aKx = 0;
    private com.baidu.tbadk.util.e<Boolean> bDD = new t(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(FrsActivity frsActivity) {
        this.bDB = frsActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        com.baidu.tieba.frs.entelechy.b.d dVar;
        a aVar;
        Cdo cdo;
        com.baidu.tieba.tbadkCore.p pVar;
        bq bqVar;
        bq bqVar2;
        com.baidu.tieba.tbadkCore.p pVar2;
        bq bqVar3;
        com.baidu.tieba.tbadkCore.data.f fVar;
        bq bqVar4;
        com.baidu.tieba.tbadkCore.data.f fVar2;
        com.baidu.tieba.tbadkCore.p pVar3;
        com.baidu.tieba.tbadkCore.p pVar4;
        com.baidu.tieba.tbadkCore.p pVar5;
        com.baidu.tieba.tbadkCore.data.f fVar3;
        int i4;
        boolean z;
        com.baidu.tieba.tbadkCore.data.f fVar4;
        int i5;
        boolean z2;
        Cdo cdo2;
        com.baidu.tieba.frs.i.p pVar6;
        a aVar2;
        com.baidu.tieba.frs.entelechy.b.d dVar2;
        com.baidu.tieba.frs.i.p pVar7;
        dVar = this.bDB.bCV;
        if (dVar != null) {
            dVar2 = this.bDB.bCV;
            pVar7 = this.bDB.bCR;
            dVar2.a(absListView, i, i2, i3, pVar7.aaq());
        }
        aVar = this.bDB.bDe;
        if (aVar != null) {
            aVar2 = this.bDB.bDe;
            aVar2.ZQ();
        }
        cdo = this.bDB.bCY;
        if (cdo != null) {
            cdo2 = this.bDB.bCY;
            pVar6 = this.bDB.bCR;
            cdo2.a(absListView, i, i2, i3, pVar6.aaq(), this.bDD);
        }
        pVar = this.bDB.bCF;
        if (pVar != null) {
            bqVar = this.bDB.bCD;
            if (bqVar != null) {
                bqVar2 = this.bDB.bCD;
                if (bqVar2.Ww() != null) {
                    pVar2 = this.bDB.bCF;
                    int baV = pVar2.baV();
                    bqVar3 = this.bDB.bCD;
                    int headerViewsCount = ((i + i2) - bqVar3.getListView().getHeaderViewsCount()) - baV;
                    int i6 = (headerViewsCount - 1) + baV;
                    fVar = this.bDB.bCz;
                    if (fVar != null) {
                        fVar2 = this.bDB.bCz;
                        int qz = fVar2.qz(headerViewsCount);
                        if (qz >= 0 && i6 >= 0) {
                            pVar3 = this.bDB.bCF;
                            if (i6 < pVar3.getThreadList().size()) {
                                pVar4 = this.bDB.bCF;
                                com.baidu.adp.widget.ListView.v vVar = pVar4.getThreadList().get(i6);
                                if (vVar instanceof b) {
                                    fVar4 = this.bDB.bCz;
                                    fVar4.c(headerViewsCount, 1, this.bDB.forumId, qz);
                                    i5 = this.bDB.mPn;
                                    com.baidu.tieba.recapp.report.a a = com.baidu.tieba.recapp.report.e.a((b) vVar, "show", i5);
                                    z2 = this.bDB.bCy;
                                    a.bG("isCache", String.valueOf(z2));
                                    com.baidu.tieba.recapp.report.b.aUO().a(a);
                                } else {
                                    pVar5 = this.bDB.bCF;
                                    ForumData aDN = pVar5.aDN();
                                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                                    fVar3 = this.bDB.bCz;
                                    fVar3.c(headerViewsCount, 2, this.bDB.forumId, qz);
                                    i4 = this.bDB.mPn;
                                    com.baidu.tieba.recapp.report.a i7 = com.baidu.tieba.recapp.report.e.i("store", qz, i4);
                                    i7.bG("page", "FRS");
                                    z = this.bDB.bCy;
                                    i7.bG("isCache", String.valueOf(z));
                                    if (aDN != null) {
                                        i7.bG("fid", aDN.getId());
                                        i7.bG("fc1", aDN.getFirst_class());
                                        i7.bG("fc2", aDN.getSecond_class());
                                    }
                                    if (currentAccountObj != null) {
                                        i7.bG("vc", String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
                                    }
                                    com.baidu.tieba.recapp.report.b.aUO().a(i7);
                                }
                            }
                        }
                    }
                    this.aKy = i;
                    this.aKx = (i + i2) - 1;
                    bqVar4 = this.bDB.bCD;
                    bqVar4.aa(this.aKy, this.aKx);
                }
            }
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        com.baidu.tieba.frs.i.p pVar;
        Cdo cdo;
        boolean z;
        bq bqVar;
        bq bqVar2;
        bq bqVar3;
        com.baidu.adp.widget.ListView.x xVar;
        bq bqVar4;
        Cdo cdo2;
        com.baidu.tieba.frs.i.p pVar2;
        pVar = this.bDB.bCR;
        if (pVar != null) {
            pVar2 = this.bDB.bCR;
            pVar2.setScrollState(i);
        }
        cdo = this.bDB.bCY;
        if (cdo != null) {
            cdo2 = this.bDB.bCY;
            cdo2.onScrollStateChanged(absListView, i);
        }
        if (i == 2 || i == 1) {
            z = this.bDB.bCM;
            if (!z) {
                this.bDB.bCM = true;
                bqVar = this.bDB.bCD;
                bqVar.Wy();
            }
        }
        if (this.bDB.bCN == null) {
            this.bDB.bCN = new com.baidu.tbadk.performanceLog.e();
            this.bDB.bCN.eQ(1000);
        }
        com.baidu.tbadk.core.view.at.vG().aI(i == 0);
        if (i == 0) {
            bqVar3 = this.bDB.bCD;
            xVar = this.bDB.bDx;
            bqVar3.a(xVar);
            bqVar4 = this.bDB.bCD;
            bqVar4.Z(this.aKy, this.aKx);
        } else {
            bqVar2 = this.bDB.bCD;
            bqVar2.a((com.baidu.adp.widget.ListView.x) null);
        }
        this.bDB.bCN.ED();
    }
}
