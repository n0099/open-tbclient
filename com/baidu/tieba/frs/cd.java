package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cd implements com.baidu.tieba.tbadkCore.aj {
    final /* synthetic */ bq aFg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(bq bqVar) {
        this.aFg = bqVar;
    }

    @Override // com.baidu.tieba.tbadkCore.aj
    public void GR() {
        FrsActivity frsActivity;
        frsActivity = this.aFg.aDc;
        frsActivity.FM();
    }

    @Override // com.baidu.tieba.tbadkCore.aj
    public void GS() {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        bdTypeListView = this.aFg.aEm;
        if (bdTypeListView != null) {
            bdTypeListView2 = this.aFg.aEm;
            bdTypeListView2.setSelection(0);
        }
    }
}
