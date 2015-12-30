package com.baidu.tieba.frs.collect;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.tbadkCore.ab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements ab.a {
    final /* synthetic */ l bki;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar) {
        this.bki = lVar;
    }

    @Override // com.baidu.tieba.tbadkCore.ab.a
    public void Op() {
        MyCollectFrsActivity myCollectFrsActivity;
        myCollectFrsActivity = this.bki.bjg;
        myCollectFrsActivity.Nm();
    }

    @Override // com.baidu.tieba.tbadkCore.ab.a
    public void Oq() {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        bdTypeListView = this.bki.bkg;
        if (bdTypeListView != null) {
            bdTypeListView2 = this.bki.bkg;
            bdTypeListView2.setSelection(0);
        }
    }
}
