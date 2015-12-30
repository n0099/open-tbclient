package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.tbadkCore.ab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cl implements ab.a {
    final /* synthetic */ cg bhg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(cg cgVar) {
        this.bhg = cgVar;
    }

    @Override // com.baidu.tieba.tbadkCore.ab.a
    public void Op() {
        this.bhg.beB.Nm();
    }

    @Override // com.baidu.tieba.tbadkCore.ab.a
    public void Oq() {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        bdTypeListView = this.bhg.bgG;
        if (bdTypeListView != null) {
            bdTypeListView2 = this.bhg.bgG;
            bdTypeListView2.setSelection(0);
        }
    }
}
