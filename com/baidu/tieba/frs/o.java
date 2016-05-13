package com.baidu.tieba.frs;

import android.widget.AbsListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tieba.recapp.report.a;
import com.baidu.tieba.recapp.report.b;
/* loaded from: classes.dex */
class o implements AbsListView.OnScrollListener {
    final /* synthetic */ FrsActivity bhl;
    private com.baidu.tbadk.util.e<Boolean> bhn = new p(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FrsActivity frsActivity) {
        this.bhl = frsActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        com.baidu.tieba.frs.entelechy.b.d dVar;
        fk fkVar;
        com.baidu.tieba.tbadkCore.o oVar;
        cn cnVar;
        cn cnVar2;
        com.baidu.tieba.tbadkCore.o oVar2;
        cn cnVar3;
        com.baidu.tieba.tbadkCore.data.f fVar;
        com.baidu.tieba.tbadkCore.data.f fVar2;
        com.baidu.tieba.tbadkCore.o oVar3;
        com.baidu.tieba.tbadkCore.o oVar4;
        com.baidu.tieba.tbadkCore.o oVar5;
        com.baidu.tieba.tbadkCore.data.f fVar3;
        int i4;
        boolean z;
        com.baidu.tieba.tbadkCore.data.f fVar4;
        int i5;
        boolean z2;
        fk fkVar2;
        com.baidu.tieba.frs.h.m mVar;
        com.baidu.tieba.frs.entelechy.b.d dVar2;
        com.baidu.tieba.frs.h.m mVar2;
        dVar = this.bhl.bgI;
        if (dVar != null) {
            dVar2 = this.bhl.bgI;
            mVar2 = this.bhl.bgE;
            dVar2.a(absListView, i, i2, i3, mVar2.Ua());
        }
        fkVar = this.bhl.bgK;
        if (fkVar != null) {
            fkVar2 = this.bhl.bgK;
            mVar = this.bhl.bgE;
            fkVar2.a(absListView, i, i2, i3, mVar.Ua(), this.bhn);
        }
        oVar = this.bhl.bgq;
        if (oVar != null) {
            cnVar = this.bhl.bgo;
            if (cnVar != null) {
                cnVar2 = this.bhl.bgo;
                if (cnVar2.Ra() != null) {
                    oVar2 = this.bhl.bgq;
                    int aSJ = oVar2.aSJ();
                    cnVar3 = this.bhl.bgo;
                    int headerViewsCount = ((i + i2) - cnVar3.QR().getHeaderViewsCount()) - aSJ;
                    int i6 = (headerViewsCount - 1) + aSJ;
                    fVar = this.bhl.bgl;
                    if (fVar != null) {
                        fVar2 = this.bhl.bgl;
                        int pj = fVar2.pj(headerViewsCount);
                        if (pj >= 0 && i6 >= 0) {
                            oVar3 = this.bhl.bgq;
                            if (i6 < oVar3.getThreadList().size()) {
                                oVar4 = this.bhl.bgq;
                                com.baidu.adp.widget.ListView.v vVar = oVar4.getThreadList().get(i6);
                                if (vVar instanceof com.baidu.tbadk.core.data.c) {
                                    fVar4 = this.bhl.bgl;
                                    fVar4.c(headerViewsCount, 1, this.bhl.forumId, pj);
                                    i5 = this.bhl.mPn;
                                    a a = com.baidu.tieba.recapp.report.e.a((com.baidu.tbadk.core.data.c) vVar, "show", i5);
                                    z2 = this.bhl.bgk;
                                    a.bE("isCache", String.valueOf(z2));
                                    b.aLJ().a(a);
                                    return;
                                }
                                oVar5 = this.bhl.bgq;
                                ForumData avD = oVar5.avD();
                                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                                fVar3 = this.bhl.bgl;
                                fVar3.c(headerViewsCount, 2, this.bhl.forumId, pj);
                                i4 = this.bhl.mPn;
                                a i7 = com.baidu.tieba.recapp.report.e.i("store", pj, i4);
                                i7.bE("page", "FRS");
                                z = this.bhl.bgk;
                                i7.bE("isCache", String.valueOf(z));
                                if (avD != null) {
                                    i7.bE("fid", avD.getId());
                                    i7.bE("fc1", avD.getFirst_class());
                                    i7.bE("fc2", avD.getSecond_class());
                                }
                                if (currentAccountObj != null) {
                                    i7.bE("vc", String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
                                }
                                b.aLJ().a(i7);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        com.baidu.tieba.frs.h.m mVar;
        fk fkVar;
        boolean z;
        cn cnVar;
        cn cnVar2;
        cn cnVar3;
        cn cnVar4;
        com.baidu.adp.widget.ListView.x xVar;
        cn cnVar5;
        cn cnVar6;
        fk fkVar2;
        com.baidu.tieba.frs.h.m mVar2;
        mVar = this.bhl.bgE;
        if (mVar != null) {
            mVar2 = this.bhl.bgE;
            mVar2.setScrollState(i);
        }
        fkVar = this.bhl.bgK;
        if (fkVar != null) {
            fkVar2 = this.bhl.bgK;
            fkVar2.onScrollStateChanged(absListView, i);
        }
        if (i == 2 || i == 1) {
            z = this.bhl.bgy;
            if (!z) {
                this.bhl.bgy = true;
                cnVar = this.bhl.bgo;
                cnVar.Re();
            }
        }
        if (this.bhl.bgz == null) {
            this.bhl.bgz = new com.baidu.tbadk.performanceLog.e();
            this.bhl.bgz.eL(1000);
        }
        com.baidu.tbadk.core.view.at.vE().aK(i == 0);
        if (i == 0) {
            cnVar4 = this.bhl.bgo;
            xVar = this.bhl.bhi;
            cnVar4.a(xVar);
            cnVar5 = this.bhl.bgo;
            cnVar5.cR(false);
            this.bhl.AD = false;
            cnVar6 = this.bhl.bgo;
            cnVar6.Rm();
        } else {
            cnVar2 = this.bhl.bgo;
            cnVar2.a((com.baidu.adp.widget.ListView.x) null);
            cnVar3 = this.bhl.bgo;
            cnVar3.cR(true);
            this.bhl.AD = true;
        }
        this.bhl.bgz.Eu();
    }
}
