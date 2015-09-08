package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.tbadkCore.aa;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bn implements aa.a {
    final /* synthetic */ bi aXy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(bi biVar) {
        this.aXy = biVar;
    }

    @Override // com.baidu.tieba.tbadkCore.aa.a
    public void Mj() {
        this.aXy.aVM.Lk();
    }

    @Override // com.baidu.tieba.tbadkCore.aa.a
    public void Mk() {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        bdTypeListView = this.aXy.aWY;
        if (bdTypeListView != null) {
            bdTypeListView2 = this.aXy.aWY;
            bdTypeListView2.setSelection(0);
        }
    }
}
