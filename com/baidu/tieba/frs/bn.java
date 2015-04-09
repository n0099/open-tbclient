package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bn implements com.baidu.tieba.tbadkCore.am {
    final /* synthetic */ bf aMc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(bf bfVar) {
        this.aMc = bfVar;
    }

    @Override // com.baidu.tieba.tbadkCore.am
    public void KA() {
        FrsActivity frsActivity;
        frsActivity = this.aMc.aKd;
        frsActivity.Jz();
    }

    @Override // com.baidu.tieba.tbadkCore.am
    public void KB() {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        bdTypeListView = this.aMc.aLu;
        if (bdTypeListView != null) {
            bdTypeListView2 = this.aMc.aLu;
            bdTypeListView2.setSelection(0);
        }
    }
}
