package com.baidu.tieba.frs;

import com.baidu.tieba.tbadkCore.v;
import com.baidu.tieba.view.BdExpandListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements v.a {
    final /* synthetic */ au bVN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(au auVar) {
        this.bVN = auVar;
    }

    @Override // com.baidu.tieba.tbadkCore.v.a
    public void aaX() {
        r rVar;
        rVar = this.bVN.bVm;
        rVar.aat();
    }

    @Override // com.baidu.tieba.tbadkCore.v.a
    public void aaY() {
        BdExpandListView bdExpandListView;
        BdExpandListView bdExpandListView2;
        com.baidu.tieba.play.ac acVar;
        com.baidu.tieba.play.ac acVar2;
        int i;
        int i2;
        bdExpandListView = this.bVN.bVv;
        if (bdExpandListView != null) {
            bdExpandListView2 = this.bVN.bVv;
            bdExpandListView2.setSelection(0);
            acVar = this.bVN.bVJ;
            if (acVar != null) {
                acVar2 = this.bVN.bVJ;
                i = this.bVN.bVc;
                i2 = this.bVN.bVd;
                acVar2.a(i, i2, false, true);
            }
        }
    }
}
