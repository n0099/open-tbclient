package com.baidu.tieba.frs.frsgood;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.tbadkCore.aa;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements aa.a {
    final /* synthetic */ x bap;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(x xVar) {
        this.bap = xVar;
    }

    @Override // com.baidu.tieba.tbadkCore.aa.a
    public void Mu() {
    }

    @Override // com.baidu.tieba.tbadkCore.aa.a
    public void Mv() {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        bdTypeListView = this.bap.aWL;
        if (bdTypeListView != null) {
            bdTypeListView2 = this.bap.aWL;
            bdTypeListView2.setSelection(0);
        }
    }
}
