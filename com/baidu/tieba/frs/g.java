package com.baidu.tieba.frs;

import android.widget.AbsListView;
/* loaded from: classes.dex */
class g implements AbsListView.OnScrollListener {
    final /* synthetic */ FrsActivity aUz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(FrsActivity frsActivity) {
        this.aUz = frsActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        com.baidu.tieba.frs.b.a aVar;
        int i4;
        bs bsVar;
        int i5;
        com.baidu.tieba.tbadkCore.data.b bVar;
        com.baidu.tieba.tbadkCore.data.b bVar2;
        com.baidu.tieba.tbadkCore.o oVar;
        com.baidu.tieba.tbadkCore.o oVar2;
        com.baidu.tieba.tbadkCore.data.b bVar3;
        String str;
        com.baidu.tieba.tbadkCore.data.b bVar4;
        String str2;
        aVar = this.aUz.aTZ;
        aVar.onScroll(absListView, i, i2, i3);
        i4 = this.aUz.aTF;
        int i6 = (i + i2) - i4;
        bsVar = this.aUz.aTJ;
        int Lt = i6 - bsVar.LZ().Lt();
        i5 = this.aUz.aTF;
        int i7 = (i5 + Lt) - 1;
        bVar = this.aUz.aTG;
        if (bVar != null) {
            bVar2 = this.aUz.aTG;
            if (bVar2.kS(Lt) && i7 >= 0) {
                oVar = this.aUz.aTL;
                if (i7 < oVar.getThreadList().size()) {
                    oVar2 = this.aUz.aTL;
                    if (oVar2.getThreadList().get(i7) instanceof com.baidu.tbadk.core.data.b) {
                        bVar4 = this.aUz.aTG;
                        str2 = this.aUz.forumId;
                        bVar4.d(Lt, 1, str2);
                        return;
                    }
                    bVar3 = this.aUz.aTG;
                    str = this.aUz.forumId;
                    bVar3.d(Lt, 2, str);
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
        aVar = this.aUz.aTZ;
        if (aVar != null) {
            aVar2 = this.aUz.aTZ;
            aVar2.setScrollState(i);
        }
        if (i == 2 || i == 1) {
            z = this.aUz.aTT;
            if (!z) {
                this.aUz.aTT = true;
                bsVar = this.aUz.aTJ;
                bsVar.Md();
            }
        }
        if (this.aUz.aTU == null) {
            this.aUz.aTU = new com.baidu.tbadk.performanceLog.e();
            this.aUz.aTU.ez(1000);
        }
        if (i == 0) {
            bsVar4 = this.aUz.aTJ;
            wVar = this.aUz.aUv;
            bsVar4.a(wVar);
            bsVar5 = this.aUz.aTJ;
            bsVar5.cf(false);
            this.aUz.Ji = false;
        } else {
            bsVar2 = this.aUz.aTJ;
            bsVar2.a((com.baidu.adp.widget.ListView.w) null);
            bsVar3 = this.aUz.aTJ;
            bsVar3.cf(true);
            this.aUz.Ji = true;
        }
        this.aUz.aTU.DE();
    }
}
