package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.tbadkCore.aa;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bx implements aa.a {
    final /* synthetic */ bs aXm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(bs bsVar) {
        this.aXm = bsVar;
    }

    @Override // com.baidu.tieba.tbadkCore.aa.a
    public void Mu() {
        this.aXm.aVn.Ls();
    }

    @Override // com.baidu.tieba.tbadkCore.aa.a
    public void Mv() {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        bdTypeListView = this.aXm.aWL;
        if (bdTypeListView != null) {
            bdTypeListView2 = this.aXm.aWL;
            bdTypeListView2.setSelection(0);
        }
    }
}
