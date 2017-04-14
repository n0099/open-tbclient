package com.baidu.tieba.frs;

import com.baidu.tieba.tbadkCore.x;
import com.baidu.tieba.view.BdExpandListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc implements x.a {
    final /* synthetic */ az bOO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(az azVar) {
        this.bOO = azVar;
    }

    @Override // com.baidu.tieba.tbadkCore.x.a
    public void aas() {
        FrsActivity frsActivity;
        frsActivity = this.bOO.bOf;
        frsActivity.Zq();
    }

    @Override // com.baidu.tieba.tbadkCore.x.a
    public void aat() {
        BdExpandListView bdExpandListView;
        BdExpandListView bdExpandListView2;
        com.baidu.tieba.play.ac acVar;
        com.baidu.tieba.play.ac acVar2;
        int i;
        int i2;
        bdExpandListView = this.bOO.bOm;
        if (bdExpandListView != null) {
            bdExpandListView2 = this.bOO.bOm;
            bdExpandListView2.setSelection(0);
            acVar = this.bOO.aRf;
            if (acVar != null) {
                acVar2 = this.bOO.aRf;
                i = this.bOO.aRj;
                i2 = this.bOO.aRi;
                acVar2.a(i, i2, false, true);
            }
        }
    }
}
