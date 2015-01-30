package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cc implements com.baidu.tieba.tbadkCore.aj {
    final /* synthetic */ bp aGj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(bp bpVar) {
        this.aGj = bpVar;
    }

    @Override // com.baidu.tieba.tbadkCore.aj
    public void Ho() {
        FrsActivity frsActivity;
        frsActivity = this.aGj.aEd;
        frsActivity.Gj();
    }

    @Override // com.baidu.tieba.tbadkCore.aj
    public void Hp() {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        bdTypeListView = this.aGj.aFo;
        if (bdTypeListView != null) {
            bdTypeListView2 = this.aGj.aFo;
            bdTypeListView2.setSelection(0);
        }
    }
}
