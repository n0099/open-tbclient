package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bn implements com.baidu.tieba.tbadkCore.am {
    final /* synthetic */ bf aLR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(bf bfVar) {
        this.aLR = bfVar;
    }

    @Override // com.baidu.tieba.tbadkCore.am
    public void Kq() {
        FrsActivity frsActivity;
        frsActivity = this.aLR.aJT;
        frsActivity.Jt();
    }

    @Override // com.baidu.tieba.tbadkCore.am
    public void Kr() {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        bdTypeListView = this.aLR.aLk;
        if (bdTypeListView != null) {
            bdTypeListView2 = this.aLR.aLk;
            bdTypeListView2.setSelection(0);
        }
    }
}
