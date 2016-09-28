package com.baidu.tieba.frs;

import android.widget.AbsListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.b;
import com.baidu.tieba.frs.i.a;
/* loaded from: classes.dex */
class u implements AbsListView.OnScrollListener {
    final /* synthetic */ FrsActivity bQi;
    private int aMt = 0;
    private int aMs = 0;
    private com.baidu.tbadk.util.e<Boolean> bQk = new v(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(FrsActivity frsActivity) {
        this.bQi = frsActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        com.baidu.tieba.frs.entelechy.b.d dVar;
        a aVar;
        dj djVar;
        bm bmVar;
        bm bmVar2;
        bm bmVar3;
        com.baidu.tieba.tbadkCore.data.f fVar;
        bm bmVar4;
        com.baidu.tieba.tbadkCore.data.f fVar2;
        com.baidu.tieba.tbadkCore.data.f fVar3;
        int i4;
        boolean z;
        com.baidu.tieba.tbadkCore.data.f fVar4;
        int i5;
        boolean z2;
        dj djVar2;
        com.baidu.tieba.frs.i.p pVar;
        a aVar2;
        com.baidu.tieba.frs.entelechy.b.d dVar2;
        com.baidu.tieba.frs.i.p pVar2;
        dVar = this.bQi.bPy;
        if (dVar != null) {
            dVar2 = this.bQi.bPy;
            pVar2 = this.bQi.bPu;
            dVar2.a(absListView, i, i2, i3, pVar2.afR());
        }
        aVar = this.bQi.bPI;
        if (aVar != null) {
            aVar2 = this.bQi.bPI;
            aVar2.afr();
        }
        djVar = this.bQi.bPB;
        if (djVar != null) {
            djVar2 = this.bQi.bPB;
            pVar = this.bQi.bPu;
            djVar2.a(absListView, i, i2, i3, pVar.afR(), this.bQk);
        }
        if (this.bQi.bPk != null) {
            bmVar = this.bQi.bPi;
            if (bmVar != null) {
                bmVar2 = this.bQi.bPi;
                if (bmVar2.abW() != null) {
                    int biz = this.bQi.bPk.biz();
                    bmVar3 = this.bQi.bPi;
                    int headerViewsCount = ((i + i2) - bmVar3.abN().getHeaderViewsCount()) - biz;
                    int i6 = (headerViewsCount - 1) + biz;
                    fVar = this.bQi.bPe;
                    if (fVar != null) {
                        fVar2 = this.bQi.bPe;
                        int rJ = fVar2.rJ(headerViewsCount);
                        if (rJ >= 0 && i6 >= 0 && i6 < this.bQi.bPk.getThreadList().size()) {
                            com.baidu.adp.widget.ListView.v vVar = this.bQi.bPk.getThreadList().get(i6);
                            if (vVar instanceof b) {
                                fVar4 = this.bQi.bPe;
                                fVar4.c(headerViewsCount, 1, this.bQi.forumId, rJ);
                                i5 = this.bQi.mPn;
                                com.baidu.tieba.recapp.report.a a = com.baidu.tieba.recapp.report.e.a((b) vVar, "show", i5);
                                z2 = this.bQi.bPd;
                                a.bN("isCache", String.valueOf(z2));
                                com.baidu.tieba.recapp.report.b.bce().a(a);
                            } else {
                                ForumData aMr = this.bQi.bPk.aMr();
                                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                                fVar3 = this.bQi.bPe;
                                fVar3.c(headerViewsCount, 2, this.bQi.forumId, rJ);
                                i4 = this.bQi.mPn;
                                com.baidu.tieba.recapp.report.a j = com.baidu.tieba.recapp.report.e.j("store", rJ, i4);
                                j.bN("page", "FRS");
                                z = this.bQi.bPd;
                                j.bN("isCache", String.valueOf(z));
                                if (aMr != null) {
                                    j.bN("fid", aMr.getId());
                                    j.bN("fc1", aMr.getFirst_class());
                                    j.bN("fc2", aMr.getSecond_class());
                                }
                                if (currentAccountObj != null) {
                                    j.bN("vc", String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
                                }
                                com.baidu.tieba.recapp.report.b.bce().a(j);
                            }
                        }
                    }
                    this.aMt = i;
                    this.aMs = (i + i2) - 1;
                    bmVar4 = this.bQi.bPi;
                    bmVar4.ah(this.aMt, this.aMs);
                }
            }
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        com.baidu.tieba.frs.i.p pVar;
        dj djVar;
        boolean z;
        bm bmVar;
        bm bmVar2;
        bm bmVar3;
        com.baidu.adp.widget.ListView.x xVar;
        bm bmVar4;
        dj djVar2;
        com.baidu.tieba.frs.i.p pVar2;
        pVar = this.bQi.bPu;
        if (pVar != null) {
            pVar2 = this.bQi.bPu;
            pVar2.setScrollState(i);
        }
        djVar = this.bQi.bPB;
        if (djVar != null) {
            djVar2 = this.bQi.bPB;
            djVar2.onScrollStateChanged(absListView, i);
        }
        if (i == 2 || i == 1) {
            z = this.bQi.bPp;
            if (!z) {
                this.bQi.bPp = true;
                bmVar = this.bQi.bPi;
                bmVar.abY();
            }
        }
        if (this.bQi.bPq == null) {
            this.bQi.bPq = new com.baidu.tbadk.performanceLog.e();
            this.bQi.bPq.fd(1000);
        }
        if (i != 0) {
            bmVar2 = this.bQi.bPi;
            bmVar2.a((com.baidu.adp.widget.ListView.x) null);
        } else {
            com.baidu.tieba.card.cb.Oj().cs(true);
            bmVar3 = this.bQi.bPi;
            xVar = this.bQi.bQe;
            bmVar3.a(xVar);
            bmVar4 = this.bQi.bPi;
            bmVar4.ag(this.aMt, this.aMs);
        }
        this.bQi.bPq.FV();
        if (i == 0) {
            this.bQi.aaQ();
        }
    }
}
