package com.baidu.tieba.frs.frsgood;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.tbadkCore.aa;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements aa.a {
    final /* synthetic */ y bnw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(y yVar) {
        this.bnw = yVar;
    }

    @Override // com.baidu.tieba.tbadkCore.aa.a
    public void Qs() {
    }

    @Override // com.baidu.tieba.tbadkCore.aa.a
    public void Qt() {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        bdTypeListView = this.bnw.bjt;
        if (bdTypeListView != null) {
            bdTypeListView2 = this.bnw.bjt;
            bdTypeListView2.setSelection(0);
        }
    }
}
