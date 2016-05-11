package com.baidu.tieba.frs;

import com.baidu.tieba.tbadkCore.ab;
import com.baidu.tieba.view.BdExpandListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ct implements ab.a {
    final /* synthetic */ cn bkx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ct(cn cnVar) {
        this.bkx = cnVar;
    }

    @Override // com.baidu.tieba.tbadkCore.ab.a
    public void Rr() {
        FrsActivity frsActivity;
        frsActivity = this.bkx.bjB;
        frsActivity.PY();
    }

    @Override // com.baidu.tieba.tbadkCore.ab.a
    public void Rs() {
        BdExpandListView bdExpandListView;
        BdExpandListView bdExpandListView2;
        bdExpandListView = this.bkx.bjM;
        if (bdExpandListView != null) {
            bdExpandListView2 = this.bkx.bjM;
            bdExpandListView2.setSelection(0);
        }
    }
}
