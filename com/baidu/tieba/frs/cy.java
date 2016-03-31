package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.tbadkCore.aa;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cy implements aa.a {
    final /* synthetic */ cs bpe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cy(cs csVar) {
        this.bpe = csVar;
    }

    @Override // com.baidu.tieba.tbadkCore.aa.a
    public void Sl() {
        FrsActivity frsActivity;
        frsActivity = this.bpe.blH;
        frsActivity.QY();
    }

    @Override // com.baidu.tieba.tbadkCore.aa.a
    public void Sm() {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        bdTypeListView = this.bpe.boD;
        if (bdTypeListView != null) {
            bdTypeListView2 = this.bpe.boD;
            bdTypeListView2.setSelection(0);
        }
    }
}
