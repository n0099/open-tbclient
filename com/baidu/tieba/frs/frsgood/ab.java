package com.baidu.tieba.frs.frsgood;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.tbadkCore.aa;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements aa.a {
    final /* synthetic */ x aZS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(x xVar) {
        this.aZS = xVar;
    }

    @Override // com.baidu.tieba.tbadkCore.aa.a
    public void Mj() {
    }

    @Override // com.baidu.tieba.tbadkCore.aa.a
    public void Mk() {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        bdTypeListView = this.aZS.aWY;
        if (bdTypeListView != null) {
            bdTypeListView2 = this.aZS.aWY;
            bdTypeListView2.setSelection(0);
        }
    }
}
