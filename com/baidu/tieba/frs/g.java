package com.baidu.tieba.frs;

import android.widget.AbsListView;
/* loaded from: classes.dex */
class g implements AbsListView.OnScrollListener {
    final /* synthetic */ FrsActivity aUK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(FrsActivity frsActivity) {
        this.aUK = frsActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        com.baidu.tieba.frs.b.a aVar;
        com.baidu.tieba.tbadkCore.o oVar;
        bs bsVar;
        bs bsVar2;
        com.baidu.tieba.tbadkCore.o oVar2;
        int i4;
        bs bsVar3;
        int i5;
        com.baidu.tieba.tbadkCore.data.b bVar;
        com.baidu.tieba.tbadkCore.data.b bVar2;
        com.baidu.tieba.tbadkCore.o oVar3;
        com.baidu.tieba.tbadkCore.o oVar4;
        com.baidu.tieba.tbadkCore.data.b bVar3;
        String str;
        int i6;
        com.baidu.tieba.tbadkCore.data.b bVar4;
        String str2;
        int i7;
        aVar = this.aUK.aUk;
        aVar.onScroll(absListView, i, i2, i3);
        oVar = this.aUK.aTW;
        if (oVar != null) {
            bsVar = this.aUK.aTU;
            if (bsVar != null) {
                bsVar2 = this.aUK.aTU;
                if (bsVar2.LV() != null) {
                    oVar2 = this.aUK.aTW;
                    int avN = oVar2.avN();
                    i4 = this.aUK.aTQ;
                    int i8 = (i + i2) - i4;
                    bsVar3 = this.aUK.aTU;
                    int Lp = (i8 - bsVar3.LV().Lp()) - avN;
                    i5 = this.aUK.aTQ;
                    int i9 = ((i5 + Lp) - 1) + avN;
                    bVar = this.aUK.aTR;
                    if (bVar != null) {
                        bVar2 = this.aUK.aTR;
                        if (bVar2.kU(Lp) && i9 >= 0) {
                            oVar3 = this.aUK.aTW;
                            if (i9 < oVar3.getThreadList().size()) {
                                oVar4 = this.aUK.aTW;
                                com.baidu.adp.widget.ListView.u uVar = oVar4.getThreadList().get(i9);
                                if (uVar instanceof com.baidu.tbadk.core.data.b) {
                                    bVar4 = this.aUK.aTR;
                                    str2 = this.aUK.forumId;
                                    bVar4.d(Lp, 1, str2);
                                    i7 = this.aUK.mPn;
                                    com.baidu.tieba.recapp.report.b.apC().a(com.baidu.tieba.recapp.report.e.a((com.baidu.tbadk.core.data.b) uVar, "show", i7));
                                    return;
                                }
                                bVar3 = this.aUK.aTR;
                                str = this.aUK.forumId;
                                bVar3.d(Lp, 2, str);
                                i6 = this.aUK.mPn;
                                com.baidu.tieba.recapp.report.b.apC().a(com.baidu.tieba.recapp.report.e.g("store", Lp, i6));
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        com.baidu.tieba.frs.b.a aVar;
        boolean z;
        bs bsVar;
        bs bsVar2;
        bs bsVar3;
        bs bsVar4;
        com.baidu.adp.widget.ListView.w wVar;
        bs bsVar5;
        com.baidu.tieba.frs.b.a aVar2;
        aVar = this.aUK.aUk;
        if (aVar != null) {
            aVar2 = this.aUK.aUk;
            aVar2.setScrollState(i);
        }
        if (i == 2 || i == 1) {
            z = this.aUK.aUe;
            if (!z) {
                this.aUK.aUe = true;
                bsVar = this.aUK.aTU;
                bsVar.LZ();
            }
        }
        if (this.aUK.aUf == null) {
            this.aUK.aUf = new com.baidu.tbadk.performanceLog.e();
            this.aUK.aUf.ez(1000);
        }
        if (i == 0) {
            bsVar4 = this.aUK.aTU;
            wVar = this.aUK.aUG;
            bsVar4.a(wVar);
            bsVar5 = this.aUK.aTU;
            bsVar5.cf(false);
            this.aUK.Jj = false;
        } else {
            bsVar2 = this.aUK.aTU;
            bsVar2.a((com.baidu.adp.widget.ListView.w) null);
            bsVar3 = this.aUK.aTU;
            bsVar3.cf(true);
            this.aUK.Jj = true;
        }
        this.aUK.aUf.DB();
    }
}
