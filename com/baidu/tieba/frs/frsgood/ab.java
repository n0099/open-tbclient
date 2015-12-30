package com.baidu.tieba.frs.frsgood;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.tbadkCore.ab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements ab.a {
    final /* synthetic */ x bkz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(x xVar) {
        this.bkz = xVar;
    }

    @Override // com.baidu.tieba.tbadkCore.ab.a
    public void Op() {
    }

    @Override // com.baidu.tieba.tbadkCore.ab.a
    public void Oq() {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        bdTypeListView = this.bkz.bgG;
        if (bdTypeListView != null) {
            bdTypeListView2 = this.bkz.bgG;
            bdTypeListView2.setSelection(0);
        }
    }
}
