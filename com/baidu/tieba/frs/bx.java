package com.baidu.tieba.frs;

import com.baidu.tieba.tbadkCore.ac;
import com.baidu.tieba.view.BdExpandListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bx implements ac.a {
    final /* synthetic */ bq bGW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(bq bqVar) {
        this.bGW = bqVar;
    }

    @Override // com.baidu.tieba.tbadkCore.ac.a
    public void Xg() {
        FrsActivity frsActivity;
        frsActivity = this.bGW.bGh;
        frsActivity.VT();
    }

    @Override // com.baidu.tieba.tbadkCore.ac.a
    public void Xh() {
        BdExpandListView bdExpandListView;
        BdExpandListView bdExpandListView2;
        bdExpandListView = this.bGW.bGo;
        if (bdExpandListView != null) {
            bdExpandListView2 = this.bGW.bGo;
            bdExpandListView2.setSelection(0);
        }
    }
}
