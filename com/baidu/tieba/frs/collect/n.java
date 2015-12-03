package com.baidu.tieba.frs.collect;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.tbadkCore.ab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements ab.a {
    final /* synthetic */ l bgq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar) {
        this.bgq = lVar;
    }

    @Override // com.baidu.tieba.tbadkCore.ab.a
    public void NW() {
        MyCollectFrsActivity myCollectFrsActivity;
        myCollectFrsActivity = this.bgq.bfn;
        myCollectFrsActivity.MS();
    }

    @Override // com.baidu.tieba.tbadkCore.ab.a
    public void NX() {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        bdTypeListView = this.bgq.bgo;
        if (bdTypeListView != null) {
            bdTypeListView2 = this.bgq.bgo;
            bdTypeListView2.setSelection(0);
        }
    }
}
