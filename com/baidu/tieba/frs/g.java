package com.baidu.tieba.frs;

import android.widget.AbsListView;
/* loaded from: classes.dex */
class g implements AbsListView.OnScrollListener {
    final /* synthetic */ FrsActivity aUS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(FrsActivity frsActivity) {
        this.aUS = frsActivity;
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
        com.baidu.tieba.tbadkCore.data.e eVar;
        com.baidu.tieba.tbadkCore.data.e eVar2;
        com.baidu.tieba.tbadkCore.o oVar3;
        com.baidu.tieba.tbadkCore.o oVar4;
        com.baidu.tieba.tbadkCore.data.e eVar3;
        String str;
        int i6;
        com.baidu.tieba.tbadkCore.data.e eVar4;
        String str2;
        int i7;
        aVar = this.aUS.aUs;
        aVar.onScroll(absListView, i, i2, i3);
        oVar = this.aUS.aUe;
        if (oVar != null) {
            bsVar = this.aUS.aUc;
            if (bsVar != null) {
                bsVar2 = this.aUS.aUc;
                if (bsVar2.Ml() != null) {
                    oVar2 = this.aUS.aUe;
                    int awv = oVar2.awv();
                    i4 = this.aUS.aTY;
                    int i8 = (i + i2) - i4;
                    bsVar3 = this.aUS.aUc;
                    int LF = (i8 - bsVar3.Ml().LF()) - awv;
                    i5 = this.aUS.aTY;
                    int i9 = ((i5 + LF) - 1) + awv;
                    eVar = this.aUS.aTZ;
                    if (eVar != null) {
                        eVar2 = this.aUS.aTZ;
                        if (eVar2.li(LF) && i9 >= 0) {
                            oVar3 = this.aUS.aUe;
                            if (i9 < oVar3.getThreadList().size()) {
                                oVar4 = this.aUS.aUe;
                                com.baidu.adp.widget.ListView.u uVar = oVar4.getThreadList().get(i9);
                                if (uVar instanceof com.baidu.tbadk.core.data.b) {
                                    eVar4 = this.aUS.aTZ;
                                    str2 = this.aUS.forumId;
                                    eVar4.d(LF, 1, str2);
                                    i7 = this.aUS.mPn;
                                    com.baidu.tieba.recapp.report.b.aqi().a(com.baidu.tieba.recapp.report.e.a((com.baidu.tbadk.core.data.b) uVar, "show", i7));
                                    return;
                                }
                                eVar3 = this.aUS.aTZ;
                                str = this.aUS.forumId;
                                eVar3.d(LF, 2, str);
                                i6 = this.aUS.mPn;
                                com.baidu.tieba.recapp.report.b.aqi().a(com.baidu.tieba.recapp.report.e.g("store", LF, i6));
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
        aVar = this.aUS.aUs;
        if (aVar != null) {
            aVar2 = this.aUS.aUs;
            aVar2.setScrollState(i);
        }
        if (i == 2 || i == 1) {
            z = this.aUS.aUm;
            if (!z) {
                this.aUS.aUm = true;
                bsVar = this.aUS.aUc;
                bsVar.Mp();
            }
        }
        if (this.aUS.aUn == null) {
            this.aUS.aUn = new com.baidu.tbadk.performanceLog.e();
            this.aUS.aUn.ex(1000);
        }
        if (i == 0) {
            bsVar4 = this.aUS.aUc;
            wVar = this.aUS.aUO;
            bsVar4.a(wVar);
            bsVar5 = this.aUS.aUc;
            bsVar5.ch(false);
            this.aUS.Jk = false;
        } else {
            bsVar2 = this.aUS.aUc;
            bsVar2.a((com.baidu.adp.widget.ListView.w) null);
            bsVar3 = this.aUS.aUc;
            bsVar3.ch(true);
            this.aUS.Jk = true;
        }
        this.aUS.aUn.Du();
    }
}
