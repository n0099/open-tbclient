package com.baidu.tieba.frs;

import com.baidu.tieba.tbadkCore.x;
import com.baidu.tieba.view.BdExpandListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc implements x.a {
    final /* synthetic */ az bRf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(az azVar) {
        this.bRf = azVar;
    }

    @Override // com.baidu.tieba.tbadkCore.x.a
    public void abt() {
        FrsActivity frsActivity;
        frsActivity = this.bRf.bQw;
        frsActivity.aar();
    }

    @Override // com.baidu.tieba.tbadkCore.x.a
    public void abu() {
        BdExpandListView bdExpandListView;
        BdExpandListView bdExpandListView2;
        com.baidu.tieba.play.ac acVar;
        com.baidu.tieba.play.ac acVar2;
        int i;
        int i2;
        bdExpandListView = this.bRf.bQD;
        if (bdExpandListView != null) {
            bdExpandListView2 = this.bRf.bQD;
            bdExpandListView2.setSelection(0);
            acVar = this.bRf.aRh;
            if (acVar != null) {
                acVar2 = this.bRf.aRh;
                i = this.bRf.aRl;
                i2 = this.bRf.aRk;
                acVar2.a(i, i2, false, true);
            }
        }
    }
}
