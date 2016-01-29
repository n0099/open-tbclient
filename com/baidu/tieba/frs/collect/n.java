package com.baidu.tieba.frs.collect;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.tbadkCore.aa;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements aa.a {
    final /* synthetic */ l bnf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar) {
        this.bnf = lVar;
    }

    @Override // com.baidu.tieba.tbadkCore.aa.a
    public void Qs() {
        MyCollectFrsActivity myCollectFrsActivity;
        myCollectFrsActivity = this.bnf.bmb;
        myCollectFrsActivity.Pj();
    }

    @Override // com.baidu.tieba.tbadkCore.aa.a
    public void Qt() {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        bdTypeListView = this.bnf.bnc;
        if (bdTypeListView != null) {
            bdTypeListView2 = this.bnf.bnc;
            bdTypeListView2.setSelection(0);
        }
    }
}
