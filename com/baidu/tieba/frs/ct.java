package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.tbadkCore.aa;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ct implements aa.a {
    final /* synthetic */ cn bjV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ct(cn cnVar) {
        this.bjV = cnVar;
    }

    @Override // com.baidu.tieba.tbadkCore.aa.a
    public void Qs() {
        FrsActivity frsActivity;
        frsActivity = this.bjV.bgW;
        frsActivity.Pj();
    }

    @Override // com.baidu.tieba.tbadkCore.aa.a
    public void Qt() {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        bdTypeListView = this.bjV.bjt;
        if (bdTypeListView != null) {
            bdTypeListView2 = this.bjV.bjt;
            bdTypeListView2.setSelection(0);
        }
    }
}
