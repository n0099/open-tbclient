package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.tbadkCore.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs implements z.a {
    final /* synthetic */ bl aXC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(bl blVar) {
        this.aXC = blVar;
    }

    @Override // com.baidu.tieba.tbadkCore.z.a
    public void Ms() {
        FrsActivity frsActivity;
        frsActivity = this.aXC.aVx;
        frsActivity.Lt();
    }

    @Override // com.baidu.tieba.tbadkCore.z.a
    public void Mt() {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        bdTypeListView = this.aXC.aWY;
        if (bdTypeListView != null) {
            bdTypeListView2 = this.aXC.aWY;
            bdTypeListView2.setSelection(0);
        }
    }
}
