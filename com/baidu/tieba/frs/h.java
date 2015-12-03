package com.baidu.tieba.frs;

import android.widget.AbsListView;
/* loaded from: classes.dex */
class h implements AbsListView.OnScrollListener {
    final /* synthetic */ FrsActivity bag;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(FrsActivity frsActivity) {
        this.bag = frsActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        com.baidu.tieba.frs.b.a aVar;
        com.baidu.tieba.tbadkCore.p pVar;
        com.baidu.tieba.tbadkCore.p pVar2;
        com.baidu.tieba.tbadkCore.data.e eVar;
        com.baidu.tieba.tbadkCore.data.e eVar2;
        com.baidu.tieba.tbadkCore.p pVar3;
        com.baidu.tieba.tbadkCore.p pVar4;
        com.baidu.tieba.tbadkCore.data.e eVar3;
        int i4;
        com.baidu.tieba.tbadkCore.data.e eVar4;
        int i5;
        aVar = this.bag.aZF;
        aVar.onScroll(absListView, i, i2, i3);
        pVar = this.bag.aZs;
        if (pVar != null && this.bag.aZq != null && this.bag.aZq.NM() != null) {
            pVar2 = this.bag.aZs;
            int aCd = pVar2.aCd();
            int Nd = ((i + i2) - this.bag.aZq.NM().Nd()) - aCd;
            int i6 = (Nd - 1) + aCd;
            eVar = this.bag.aZn;
            if (eVar != null) {
                eVar2 = this.bag.aZn;
                int mu = eVar2.mu(Nd);
                if (mu >= 0 && i6 >= 0) {
                    pVar3 = this.bag.aZs;
                    if (i6 < pVar3.getThreadList().size()) {
                        pVar4 = this.bag.aZs;
                        com.baidu.adp.widget.ListView.u uVar = pVar4.getThreadList().get(i6);
                        if (uVar instanceof com.baidu.tbadk.core.data.b) {
                            eVar4 = this.bag.aZn;
                            eVar4.c(Nd, 1, this.bag.forumId, mu);
                            i5 = this.bag.mPn;
                            com.baidu.tieba.recapp.report.b.avU().a(com.baidu.tieba.recapp.report.e.a((com.baidu.tbadk.core.data.b) uVar, "show", i5));
                            return;
                        }
                        eVar3 = this.bag.aZn;
                        eVar3.c(Nd, 2, this.bag.forumId, mu);
                        i4 = this.bag.mPn;
                        com.baidu.tieba.recapp.report.b.avU().a(com.baidu.tieba.recapp.report.e.g("store", mu, i4));
                    }
                }
            }
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        com.baidu.tieba.frs.b.a aVar;
        boolean z;
        com.baidu.adp.widget.ListView.w wVar;
        com.baidu.tieba.frs.b.a aVar2;
        aVar = this.bag.aZF;
        if (aVar != null) {
            aVar2 = this.bag.aZF;
            aVar2.setScrollState(i);
        }
        if (i == 2 || i == 1) {
            z = this.bag.aZz;
            if (!z) {
                this.bag.aZz = true;
                this.bag.aZq.NQ();
            }
        }
        if (this.bag.aZA == null) {
            this.bag.aZA = new com.baidu.tbadk.performanceLog.e();
            this.bag.aZA.eL(1000);
        }
        if (i == 0) {
            cd cdVar = this.bag.aZq;
            wVar = this.bag.bac;
            cdVar.a(wVar);
            this.bag.aZq.cu(false);
            this.bag.JB = false;
        } else {
            this.bag.aZq.a((com.baidu.adp.widget.ListView.w) null);
            this.bag.aZq.cu(true);
            this.bag.JB = true;
        }
        this.bag.aZA.Ev();
    }
}
