package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.tbadkCore.aa;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bx implements aa.a {
    final /* synthetic */ bs aWS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(bs bsVar) {
        this.aWS = bsVar;
    }

    @Override // com.baidu.tieba.tbadkCore.aa.a
    public void Mi() {
        this.aWS.aUU.Lg();
    }

    @Override // com.baidu.tieba.tbadkCore.aa.a
    public void Mj() {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        bdTypeListView = this.aWS.aWs;
        if (bdTypeListView != null) {
            bdTypeListView2 = this.aWS.aWs;
            bdTypeListView2.setSelection(0);
        }
    }
}
