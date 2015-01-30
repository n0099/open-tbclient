package com.baidu.tieba.frs;

import android.widget.AbsListView;
/* loaded from: classes.dex */
class g implements AbsListView.OnScrollListener {
    final /* synthetic */ FrsActivity aDW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(FrsActivity frsActivity) {
        this.aDW = frsActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        boolean z;
        bp bpVar;
        com.baidu.tbadk.performanceLog.h hVar;
        bp bpVar2;
        bp bpVar3;
        bp bpVar4;
        com.baidu.tbadk.performanceLog.h hVar2;
        bp bpVar5;
        com.baidu.adp.widget.ListView.ao aoVar;
        bp bpVar6;
        bp bpVar7;
        com.baidu.tbadk.performanceLog.h hVar3;
        com.baidu.tbadk.performanceLog.h hVar4;
        if (i == 2 || i == 1) {
            z = this.aDW.aDx;
            if (!z) {
                this.aDW.aDx = true;
                bpVar = this.aDW.aCY;
                bpVar.Hm();
            }
        }
        hVar = this.aDW.aDy;
        if (hVar == null) {
            this.aDW.aDy = new com.baidu.tbadk.performanceLog.h();
            hVar3 = this.aDW.aDy;
            hVar3.dX(1000);
            hVar4 = this.aDW.aDy;
            hVar4.agK = this.aDW.aDz;
        }
        if (i == 0) {
            bpVar5 = this.aDW.aCY;
            aoVar = this.aDW.aDV;
            bpVar5.a(aoVar);
            bpVar6 = this.aDW.aCY;
            bpVar6.bT(false);
            bpVar7 = this.aDW.aCY;
            bpVar7.GT();
            this.aDW.aDo = false;
        } else {
            bpVar2 = this.aDW.aCY;
            bpVar2.a((com.baidu.adp.widget.ListView.ao) null);
            bpVar3 = this.aDW.aCY;
            bpVar3.bT(true);
            this.aDW.aDo = true;
            bpVar4 = this.aDW.aCY;
            bpVar4.FH();
        }
        hVar2 = this.aDW.aDy;
        hVar2.zf();
    }
}
