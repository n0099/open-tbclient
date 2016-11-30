package com.baidu.tieba.frs;

import com.baidu.tieba.tbadkCore.ab;
import com.baidu.tieba.view.BdExpandListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements ab.a {
    final /* synthetic */ au bUk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(au auVar) {
        this.bUk = auVar;
    }

    @Override // com.baidu.tieba.tbadkCore.ab.a
    public void adv() {
        FrsActivity frsActivity;
        frsActivity = this.bUk.bTA;
        frsActivity.acq();
    }

    @Override // com.baidu.tieba.tbadkCore.ab.a
    public void adw() {
        BdExpandListView bdExpandListView;
        BdExpandListView bdExpandListView2;
        com.baidu.tieba.play.aa aaVar;
        com.baidu.tieba.play.aa aaVar2;
        int i;
        int i2;
        bdExpandListView = this.bUk.bTH;
        if (bdExpandListView != null) {
            bdExpandListView2 = this.bUk.bTH;
            bdExpandListView2.setSelection(0);
            aaVar = this.bUk.aMM;
            if (aaVar != null) {
                aaVar2 = this.bUk.aMM;
                i = this.bUk.aMQ;
                i2 = this.bUk.aMP;
                aaVar2.a(i, i2, false, true);
            }
        }
    }
}
