package com.baidu.tieba.frs;

import com.baidu.tieba.tbadkCore.v;
import com.baidu.tieba.view.BdExpandListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements v.a {
    final /* synthetic */ at bPW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(at atVar) {
        this.bPW = atVar;
    }

    @Override // com.baidu.tieba.tbadkCore.v.a
    public void ZV() {
        r rVar;
        rVar = this.bPW.bPw;
        rVar.Zp();
    }

    @Override // com.baidu.tieba.tbadkCore.v.a
    public void ZW() {
        BdExpandListView bdExpandListView;
        BdExpandListView bdExpandListView2;
        com.baidu.tieba.play.ac acVar;
        com.baidu.tieba.play.ac acVar2;
        int i;
        int i2;
        bdExpandListView = this.bPW.bPF;
        if (bdExpandListView != null) {
            bdExpandListView2 = this.bPW.bPF;
            bdExpandListView2.setSelection(0);
            acVar = this.bPW.aRC;
            if (acVar != null) {
                acVar2 = this.bPW.aRC;
                i = this.bPW.aRG;
                i2 = this.bPW.aRF;
                acVar2.a(i, i2, false, true);
            }
        }
    }
}
