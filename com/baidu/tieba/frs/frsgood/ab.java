package com.baidu.tieba.frs.frsgood;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.tbadkCore.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements z.a {
    final /* synthetic */ x aZz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(x xVar) {
        this.aZz = xVar;
    }

    @Override // com.baidu.tieba.tbadkCore.z.a
    public void Ms() {
    }

    @Override // com.baidu.tieba.tbadkCore.z.a
    public void Mt() {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        bdTypeListView = this.aZz.aWY;
        if (bdTypeListView != null) {
            bdTypeListView2 = this.aZz.aWY;
            bdTypeListView2.setSelection(0);
        }
    }
}
