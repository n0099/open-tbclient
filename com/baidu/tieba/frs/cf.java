package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cf implements com.baidu.tieba.c.c {
    final /* synthetic */ bu aDt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(bu buVar) {
        this.aDt = buVar;
    }

    @Override // com.baidu.tieba.c.c
    public void GJ() {
        FrsActivity frsActivity;
        frsActivity = this.aDt.aBp;
        frsActivity.FG();
    }

    @Override // com.baidu.tieba.c.c
    public void GK() {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        bdTypeListView = this.aDt.aCB;
        if (bdTypeListView != null) {
            bdTypeListView2 = this.aDt.aCB;
            bdTypeListView2.setSelection(0);
        }
    }
}
