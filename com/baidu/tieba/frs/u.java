package com.baidu.tieba.frs;

import android.widget.AbsListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.b;
import com.baidu.tieba.frs.i.a;
/* loaded from: classes.dex */
class u implements AbsListView.OnScrollListener {
    final /* synthetic */ FrsActivity bQp;
    private int aQc = 0;
    private int aQb = 0;
    private com.baidu.tbadk.util.e<Boolean> bQr = new v(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(FrsActivity frsActivity) {
        this.bQp = frsActivity;
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
        dVar = this.bQp.bPG;
        if (dVar != null) {
            dVar2 = this.bQp.bPG;
            pVar2 = this.bQp.bPC;
            dVar2.a(absListView, i, i2, i3, pVar2.afD());
        }
        aVar = this.bQp.bPP;
        if (aVar != null) {
            aVar2 = this.bQp.bPP;
            aVar2.afd();
        }
        djVar = this.bQp.bPJ;
        if (djVar != null) {
            djVar2 = this.bQp.bPJ;
            pVar = this.bQp.bPC;
            djVar2.a(absListView, i, i2, i3, pVar.afD(), this.bQr);
        }
        if (this.bQp.bPq != null) {
            bmVar = this.bQp.bPo;
            if (bmVar != null) {
                bmVar2 = this.bQp.bPo;
                if (bmVar2.abJ() != null) {
                    int bhP = this.bQp.bPq.bhP();
                    bmVar3 = this.bQp.bPo;
                    int headerViewsCount = ((i + i2) - bmVar3.getListView().getHeaderViewsCount()) - bhP;
                    int i6 = (headerViewsCount - 1) + bhP;
                    fVar = this.bQp.bPk;
                    if (fVar != null) {
                        fVar2 = this.bQp.bPk;
                        int rv = fVar2.rv(headerViewsCount);
                        if (rv >= 0 && i6 >= 0 && i6 < this.bQp.bPq.getThreadList().size()) {
                            com.baidu.adp.widget.ListView.v vVar = this.bQp.bPq.getThreadList().get(i6);
                            if (vVar instanceof b) {
                                fVar4 = this.bQp.bPk;
                                fVar4.c(headerViewsCount, 1, this.bQp.forumId, rv);
                                i5 = this.bQp.mPn;
                                com.baidu.tieba.recapp.report.a a = com.baidu.tieba.recapp.report.e.a((b) vVar, "show", i5);
                                z2 = this.bQp.bPj;
                                a.bM("isCache", String.valueOf(z2));
                                com.baidu.tieba.recapp.report.b.bbu().a(a);
                            } else {
                                ForumData aLP = this.bQp.bPq.aLP();
                                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                                fVar3 = this.bQp.bPk;
                                fVar3.c(headerViewsCount, 2, this.bQp.forumId, rv);
                                i4 = this.bQp.mPn;
                                com.baidu.tieba.recapp.report.a j = com.baidu.tieba.recapp.report.e.j("store", rv, i4);
                                j.bM("page", "FRS");
                                z = this.bQp.bPj;
                                j.bM("isCache", String.valueOf(z));
                                if (aLP != null) {
                                    j.bM("fid", aLP.getId());
                                    j.bM("fc1", aLP.getFirst_class());
                                    j.bM("fc2", aLP.getSecond_class());
                                }
                                if (currentAccountObj != null) {
                                    j.bM("vc", String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
                                }
                                com.baidu.tieba.recapp.report.b.bbu().a(j);
                            }
                        }
                    }
                    this.aQc = i;
                    this.aQb = (i + i2) - 1;
                    bmVar4 = this.bQp.bPo;
                    bmVar4.ag(this.aQc, this.aQb);
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
        pVar = this.bQp.bPC;
        if (pVar != null) {
            pVar2 = this.bQp.bPC;
            pVar2.setScrollState(i);
        }
        djVar = this.bQp.bPJ;
        if (djVar != null) {
            djVar2 = this.bQp.bPJ;
            djVar2.onScrollStateChanged(absListView, i);
        }
        if (i == 2 || i == 1) {
            z = this.bQp.bPx;
            if (!z) {
                this.bQp.bPx = true;
                bmVar = this.bQp.bPo;
                bmVar.abL();
            }
        }
        if (this.bQp.bPy == null) {
            this.bQp.bPy = new com.baidu.tbadk.performanceLog.e();
            this.bQp.bPy.fe(1000);
        }
        com.baidu.tbadk.core.view.au.wK().aM(i == 0);
        if (i != 0) {
            bmVar2 = this.bQp.bPo;
            bmVar2.a((com.baidu.adp.widget.ListView.x) null);
        } else {
            com.baidu.tieba.card.cd.NI().cs(true);
            bmVar3 = this.bQp.bPo;
            xVar = this.bQp.bQl;
            bmVar3.a(xVar);
            bmVar4 = this.bQp.bPo;
            bmVar4.af(this.aQc, this.aQb);
        }
        this.bQp.bPy.FW();
    }
}
