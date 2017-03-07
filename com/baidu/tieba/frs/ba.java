package com.baidu.tieba.frs;

import com.baidu.tieba.tbadkCore.x;
import com.baidu.tieba.view.BdExpandListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements x.a {
    final /* synthetic */ ax bOZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(ax axVar) {
        this.bOZ = axVar;
    }

    @Override // com.baidu.tieba.tbadkCore.x.a
    public void ZU() {
        FrsActivity frsActivity;
        frsActivity = this.bOZ.bOq;
        frsActivity.YU();
    }

    @Override // com.baidu.tieba.tbadkCore.x.a
    public void ZV() {
        BdExpandListView bdExpandListView;
        BdExpandListView bdExpandListView2;
        com.baidu.tieba.play.ac acVar;
        com.baidu.tieba.play.ac acVar2;
        int i;
        int i2;
        bdExpandListView = this.bOZ.bOx;
        if (bdExpandListView != null) {
            bdExpandListView2 = this.bOZ.bOx;
            bdExpandListView2.setSelection(0);
            acVar = this.bOZ.aQP;
            if (acVar != null) {
                acVar2 = this.bOZ.aQP;
                i = this.bOZ.aQT;
                i2 = this.bOZ.aQS;
                acVar2.a(i, i2, false, true);
            }
        }
    }
}
