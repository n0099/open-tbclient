package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm implements com.baidu.tieba.tbadkCore.am {
    final /* synthetic */ bf aOn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(bf bfVar) {
        this.aOn = bfVar;
    }

    @Override // com.baidu.tieba.tbadkCore.am
    public void LG() {
        FrsActivity frsActivity;
        frsActivity = this.aOn.aMl;
        frsActivity.KE();
    }

    @Override // com.baidu.tieba.tbadkCore.am
    public void LH() {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        bdTypeListView = this.aOn.aNE;
        if (bdTypeListView != null) {
            bdTypeListView2 = this.aOn.aNE;
            bdTypeListView2.setSelection(0);
        }
    }
}
