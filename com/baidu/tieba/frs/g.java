package com.baidu.tieba.frs;

import android.widget.AbsListView;
/* loaded from: classes.dex */
class g implements AbsListView.OnScrollListener {
    final /* synthetic */ FrsActivity aDT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(FrsActivity frsActivity) {
        this.aDT = frsActivity;
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
            z = this.aDT.aDu;
            if (!z) {
                this.aDT.aDu = true;
                bpVar = this.aDT.aCV;
                bpVar.Hg();
            }
        }
        hVar = this.aDT.aDv;
        if (hVar == null) {
            this.aDT.aDv = new com.baidu.tbadk.performanceLog.h();
            hVar3 = this.aDT.aDv;
            hVar3.dX(1000);
            hVar4 = this.aDT.aDv;
            hVar4.agH = this.aDT.aDw;
        }
        if (i == 0) {
            bpVar5 = this.aDT.aCV;
            aoVar = this.aDT.aDS;
            bpVar5.a(aoVar);
            bpVar6 = this.aDT.aCV;
            bpVar6.bT(false);
            bpVar7 = this.aDT.aCV;
            bpVar7.GN();
            this.aDT.aDl = false;
        } else {
            bpVar2 = this.aDT.aCV;
            bpVar2.a((com.baidu.adp.widget.ListView.ao) null);
            bpVar3 = this.aDT.aCV;
            bpVar3.bT(true);
            this.aDT.aDl = true;
            bpVar4 = this.aDT.aCV;
            bpVar4.FB();
        }
        hVar2 = this.aDT.aDv;
        hVar2.yZ();
    }
}
