package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cc implements com.baidu.tieba.tbadkCore.aj {
    final /* synthetic */ bp aGg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(bp bpVar) {
        this.aGg = bpVar;
    }

    @Override // com.baidu.tieba.tbadkCore.aj
    public void Hi() {
        FrsActivity frsActivity;
        frsActivity = this.aGg.aEa;
        frsActivity.Gd();
    }

    @Override // com.baidu.tieba.tbadkCore.aj
    public void Hj() {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        bdTypeListView = this.aGg.aFl;
        if (bdTypeListView != null) {
            bdTypeListView2 = this.aGg.aFl;
            bdTypeListView2.setSelection(0);
        }
    }
}
