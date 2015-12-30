package com.baidu.tieba.frs;

import android.widget.AbsListView;
/* loaded from: classes.dex */
class i implements AbsListView.OnScrollListener {
    final /* synthetic */ FrsActivity bed;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FrsActivity frsActivity) {
        this.bed = frsActivity;
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
        com.baidu.tieba.tbadkCore.data.e eVar4;
        aVar = this.bed.bdB;
        aVar.onScroll(absListView, i, i2, i3);
        pVar = this.bed.bdo;
        if (pVar != null && this.bed.bdm != null && this.bed.bdm.Of() != null) {
            pVar2 = this.bed.bdo;
            int aEl = pVar2.aEl();
            int Nw = ((i + i2) - this.bed.bdm.Of().Nw()) - aEl;
            int i4 = (Nw - 1) + aEl;
            eVar = this.bed.bdj;
            if (eVar != null) {
                eVar2 = this.bed.bdj;
                int mV = eVar2.mV(Nw);
                if (mV >= 0 && i4 >= 0) {
                    pVar3 = this.bed.bdo;
                    if (i4 < pVar3.getThreadList().size()) {
                        pVar4 = this.bed.bdo;
                        com.baidu.adp.widget.ListView.u uVar = pVar4.getThreadList().get(i4);
                        if (uVar instanceof com.baidu.tbadk.core.data.b) {
                            eVar4 = this.bed.bdj;
                            eVar4.c(Nw, 1, this.bed.forumId, mV);
                            com.baidu.tieba.recapp.report.b.axN().a(com.baidu.tieba.recapp.report.e.a((com.baidu.tbadk.core.data.b) uVar, "show", this.bed.mPn));
                            return;
                        }
                        eVar3 = this.bed.bdj;
                        eVar3.c(Nw, 2, this.bed.forumId, mV);
                        com.baidu.tieba.recapp.report.b.axN().a(com.baidu.tieba.recapp.report.e.g("store", mV, this.bed.mPn));
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
        aVar = this.bed.bdB;
        if (aVar != null) {
            aVar2 = this.bed.bdB;
            aVar2.setScrollState(i);
        }
        if (i == 2 || i == 1) {
            z = this.bed.bdv;
            if (!z) {
                this.bed.bdv = true;
                this.bed.bdm.Oj();
            }
        }
        if (this.bed.bdw == null) {
            this.bed.bdw = new com.baidu.tbadk.performanceLog.e();
            this.bed.bdw.eF(1000);
        }
        if (i == 0) {
            cg cgVar = this.bed.bdm;
            wVar = this.bed.bdZ;
            cgVar.a(wVar);
            this.bed.bdm.cv(false);
            this.bed.JR = false;
        } else {
            this.bed.bdm.a((com.baidu.adp.widget.ListView.w) null);
            this.bed.bdm.cv(true);
            this.bed.JR = true;
        }
        this.bed.bdw.Ek();
    }
}
