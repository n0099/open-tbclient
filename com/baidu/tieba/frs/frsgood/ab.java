package com.baidu.tieba.frs.frsgood;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.tbadkCore.aa;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements aa.a {
    final /* synthetic */ x aZW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(x xVar) {
        this.aZW = xVar;
    }

    @Override // com.baidu.tieba.tbadkCore.aa.a
    public void Mi() {
    }

    @Override // com.baidu.tieba.tbadkCore.aa.a
    public void Mj() {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        bdTypeListView = this.aZW.aWD;
        if (bdTypeListView != null) {
            bdTypeListView2 = this.aZW.aWD;
            bdTypeListView2.setSelection(0);
        }
    }
}
