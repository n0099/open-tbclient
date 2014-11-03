package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cf implements com.baidu.tieba.c.c {
    final /* synthetic */ bu aDD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(bu buVar) {
        this.aDD = buVar;
    }

    @Override // com.baidu.tieba.c.c
    public void GL() {
        FrsActivity frsActivity;
        frsActivity = this.aDD.aBz;
        frsActivity.FI();
    }

    @Override // com.baidu.tieba.c.c
    public void GM() {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        bdTypeListView = this.aDD.aCL;
        if (bdTypeListView != null) {
            bdTypeListView2 = this.aDD.aCL;
            bdTypeListView2.setSelection(0);
        }
    }
}
