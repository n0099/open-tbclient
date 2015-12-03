package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.tbadkCore.ab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ci implements ab.a {
    final /* synthetic */ cd bdg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ci(cd cdVar) {
        this.bdg = cdVar;
    }

    @Override // com.baidu.tieba.tbadkCore.ab.a
    public void NW() {
        this.bdg.baC.MS();
    }

    @Override // com.baidu.tieba.tbadkCore.ab.a
    public void NX() {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        bdTypeListView = this.bdg.bcG;
        if (bdTypeListView != null) {
            bdTypeListView2 = this.bdg.bcG;
            bdTypeListView2.setSelection(0);
        }
    }
}
