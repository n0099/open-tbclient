package com.baidu.tieba.frs.frsgood;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.tbadkCore.ab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements ab.a {
    final /* synthetic */ x bgI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(x xVar) {
        this.bgI = xVar;
    }

    @Override // com.baidu.tieba.tbadkCore.ab.a
    public void NW() {
    }

    @Override // com.baidu.tieba.tbadkCore.ab.a
    public void NX() {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        bdTypeListView = this.bgI.bcG;
        if (bdTypeListView != null) {
            bdTypeListView2 = this.bgI.bcG;
            bdTypeListView2.setSelection(0);
        }
    }
}
