package com.baidu.tieba.frs;

import com.baidu.tieba.tbadkCore.ab;
import com.baidu.tieba.view.BdExpandListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt implements ab.a {
    final /* synthetic */ bm bSc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(bm bmVar) {
        this.bSc = bmVar;
    }

    @Override // com.baidu.tieba.tbadkCore.ab.a
    public void acd() {
        FrsActivity frsActivity;
        frsActivity = this.bSc.bRp;
        frsActivity.aaQ();
    }

    @Override // com.baidu.tieba.tbadkCore.ab.a
    public void ace() {
        BdExpandListView bdExpandListView;
        BdExpandListView bdExpandListView2;
        bdExpandListView = this.bSc.bRw;
        if (bdExpandListView != null) {
            bdExpandListView2 = this.bSc.bRw;
            bdExpandListView2.setSelection(0);
        }
    }
}
