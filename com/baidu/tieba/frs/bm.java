package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm implements com.baidu.tieba.tbadkCore.am {
    final /* synthetic */ bf aOm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(bf bfVar) {
        this.aOm = bfVar;
    }

    @Override // com.baidu.tieba.tbadkCore.am
    public void LF() {
        FrsActivity frsActivity;
        frsActivity = this.aOm.aMk;
        frsActivity.KD();
    }

    @Override // com.baidu.tieba.tbadkCore.am
    public void LG() {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        bdTypeListView = this.aOm.aND;
        if (bdTypeListView != null) {
            bdTypeListView2 = this.aOm.aND;
            bdTypeListView2.setSelection(0);
        }
    }
}
