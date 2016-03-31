package com.baidu.tieba.frs.frsgood;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.tbadkCore.aa;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements aa.a {
    final /* synthetic */ y bst;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(y yVar) {
        this.bst = yVar;
    }

    @Override // com.baidu.tieba.tbadkCore.aa.a
    public void Sl() {
    }

    @Override // com.baidu.tieba.tbadkCore.aa.a
    public void Sm() {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        bdTypeListView = this.bst.boD;
        if (bdTypeListView != null) {
            bdTypeListView2 = this.bst.boD;
            bdTypeListView2.setSelection(0);
        }
    }
}
