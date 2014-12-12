package com.baidu.tieba.frs;

import android.widget.AbsListView;
/* loaded from: classes.dex */
class g implements AbsListView.OnScrollListener {
    final /* synthetic */ FrsActivity aCV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(FrsActivity frsActivity) {
        this.aCV = frsActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        boolean z;
        bq bqVar;
        com.baidu.tbadk.performanceLog.h hVar;
        bq bqVar2;
        bq bqVar3;
        bq bqVar4;
        com.baidu.tbadk.performanceLog.h hVar2;
        bq bqVar5;
        com.baidu.adp.widget.ListView.ao aoVar;
        bq bqVar6;
        bq bqVar7;
        com.baidu.tbadk.performanceLog.h hVar3;
        com.baidu.tbadk.performanceLog.h hVar4;
        if (i == 2 || i == 1) {
            z = this.aCV.aCw;
            if (!z) {
                this.aCV.aCw = true;
                bqVar = this.aCV.aBX;
                bqVar.GP();
            }
        }
        hVar = this.aCV.aCx;
        if (hVar == null) {
            this.aCV.aCx = new com.baidu.tbadk.performanceLog.h();
            hVar3 = this.aCV.aCx;
            hVar3.dR(1000);
            hVar4 = this.aCV.aCx;
            hVar4.agm = this.aCV.aCy;
        }
        if (i == 0) {
            bqVar5 = this.aCV.aBX;
            aoVar = this.aCV.aCU;
            bqVar5.a(aoVar);
            bqVar6 = this.aCV.aBX;
            bqVar6.bQ(false);
            bqVar7 = this.aCV.aBX;
            bqVar7.Gw();
            this.aCV.aCn = false;
        } else {
            bqVar2 = this.aCV.aBX;
            bqVar2.a((com.baidu.adp.widget.ListView.ao) null);
            bqVar3 = this.aCV.aBX;
            bqVar3.bQ(true);
            this.aCV.aCn = true;
            bqVar4 = this.aCV.aBX;
            bqVar4.Fj();
        }
        hVar2 = this.aCV.aCx;
        hVar2.yO();
    }
}
