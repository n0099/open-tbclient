package com.baidu.tieba.frs;

import com.baidu.tieba.tbadkCore.v;
import com.baidu.tieba.view.BdExpandListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements v.a {
    final /* synthetic */ av cdV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(av avVar) {
        this.cdV = avVar;
    }

    @Override // com.baidu.tieba.tbadkCore.v.a
    public void aeO() {
        r rVar;
        rVar = this.cdV.cdv;
        rVar.aej();
    }

    @Override // com.baidu.tieba.tbadkCore.v.a
    public void aeP() {
        BdExpandListView bdExpandListView;
        BdExpandListView bdExpandListView2;
        com.baidu.tieba.play.ac acVar;
        com.baidu.tieba.play.ac acVar2;
        int i;
        int i2;
        bdExpandListView = this.cdV.cdE;
        if (bdExpandListView != null) {
            bdExpandListView2 = this.cdV.cdE;
            bdExpandListView2.setSelection(0);
            acVar = this.cdV.cdS;
            if (acVar != null) {
                acVar2 = this.cdV.cdS;
                i = this.cdV.cdm;
                i2 = this.cdV.baJ;
                acVar2.a(i, i2, false, true);
            }
        }
    }
}
