package com.baidu.tieba.frs;

import com.baidu.tieba.tbadkCore.ac;
import com.baidu.tieba.view.BdExpandListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bx implements ac.a {
    final /* synthetic */ bq bFI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(bq bqVar) {
        this.bFI = bqVar;
    }

    @Override // com.baidu.tieba.tbadkCore.ac.a
    public void WO() {
        FrsActivity frsActivity;
        frsActivity = this.bFI.bET;
        frsActivity.VB();
    }

    @Override // com.baidu.tieba.tbadkCore.ac.a
    public void WP() {
        BdExpandListView bdExpandListView;
        BdExpandListView bdExpandListView2;
        bdExpandListView = this.bFI.bFa;
        if (bdExpandListView != null) {
            bdExpandListView2 = this.bFI.bFa;
            bdExpandListView2.setSelection(0);
        }
    }
}
