package com.baidu.tieba.frs;

import com.baidu.tieba.tbadkCore.ab;
import com.baidu.tieba.view.BdExpandListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt implements ab.a {
    final /* synthetic */ bm bRV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(bm bmVar) {
        this.bRV = bmVar;
    }

    @Override // com.baidu.tieba.tbadkCore.ab.a
    public void acq() {
        FrsActivity frsActivity;
        frsActivity = this.bRV.bRi;
        frsActivity.abd();
    }

    @Override // com.baidu.tieba.tbadkCore.ab.a
    public void acr() {
        BdExpandListView bdExpandListView;
        BdExpandListView bdExpandListView2;
        bdExpandListView = this.bRV.bRp;
        if (bdExpandListView != null) {
            bdExpandListView2 = this.bRV.bRp;
            bdExpandListView2.setSelection(0);
        }
    }
}
