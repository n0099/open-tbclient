package com.baidu.tieba.frs;

import android.widget.AbsListView;
/* loaded from: classes.dex */
class j implements AbsListView.OnScrollListener {
    final /* synthetic */ FrsActivity bgz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FrsActivity frsActivity) {
        this.bgz = frsActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        com.baidu.tieba.frs.c.a aVar;
        com.baidu.tieba.tbadkCore.o oVar;
        com.baidu.tieba.tbadkCore.o oVar2;
        com.baidu.tieba.tbadkCore.data.e eVar;
        com.baidu.tieba.tbadkCore.data.e eVar2;
        com.baidu.tieba.tbadkCore.o oVar3;
        com.baidu.tieba.tbadkCore.o oVar4;
        com.baidu.tieba.tbadkCore.data.e eVar3;
        com.baidu.tieba.tbadkCore.data.e eVar4;
        aVar = this.bgz.bfS;
        aVar.onScroll(absListView, i, i2, i3);
        oVar = this.bgz.bfF;
        if (oVar != null && this.bgz.bfD != null && this.bgz.bfD.Qi() != null) {
            oVar2 = this.bgz.bfF;
            int aLp = oVar2.aLp();
            int Pw = ((i + i2) - this.bgz.bfD.Qi().Pw()) - aLp;
            int i4 = (Pw - 1) + aLp;
            eVar = this.bgz.bfA;
            if (eVar != null) {
                eVar2 = this.bgz.bfA;
                int of = eVar2.of(Pw);
                if (of >= 0 && i4 >= 0) {
                    oVar3 = this.bgz.bfF;
                    if (i4 < oVar3.getThreadList().size()) {
                        oVar4 = this.bgz.bfF;
                        com.baidu.adp.widget.ListView.u uVar = oVar4.getThreadList().get(i4);
                        if (uVar instanceof com.baidu.tbadk.core.data.c) {
                            eVar4 = this.bgz.bfA;
                            eVar4.c(Pw, 1, this.bgz.forumId, of);
                            com.baidu.tieba.recapp.report.b.aEK().a(com.baidu.tieba.recapp.report.e.a((com.baidu.tbadk.core.data.c) uVar, "show", this.bgz.mPn));
                            return;
                        }
                        eVar3 = this.bgz.bfA;
                        eVar3.c(Pw, 2, this.bgz.forumId, of);
                        com.baidu.tieba.recapp.report.b.aEK().a(com.baidu.tieba.recapp.report.e.g("store", of, this.bgz.mPn));
                    }
                }
            }
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        com.baidu.tieba.frs.c.a aVar;
        boolean z;
        com.baidu.adp.widget.ListView.w wVar;
        com.baidu.tieba.frs.c.a aVar2;
        aVar = this.bgz.bfS;
        if (aVar != null) {
            aVar2 = this.bgz.bfS;
            aVar2.setScrollState(i);
        }
        if (i == 2 || i == 1) {
            z = this.bgz.bfM;
            if (!z) {
                this.bgz.bfM = true;
                this.bgz.bfD.Qm();
            }
        }
        if (this.bgz.bfN == null) {
            this.bgz.bfN = new com.baidu.tbadk.performanceLog.e();
            this.bgz.bfN.eZ(1000);
        }
        if (i == 0) {
            cn cnVar = this.bgz.bfD;
            wVar = this.bgz.bgv;
            cnVar.a(wVar);
            this.bgz.bfD.cv(false);
            this.bgz.Kg = false;
        } else {
            this.bgz.bfD.a((com.baidu.adp.widget.ListView.w) null);
            this.bgz.bfD.cv(true);
            this.bgz.Kg = true;
        }
        this.bgz.bfN.FF();
    }
}
