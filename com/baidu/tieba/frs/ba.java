package com.baidu.tieba.frs;

import com.baidu.tieba.tbadkCore.y;
import com.baidu.tieba.view.BdExpandListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements y.a {
    final /* synthetic */ ax bHQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(ax axVar) {
        this.bHQ = axVar;
    }

    @Override // com.baidu.tieba.tbadkCore.y.a
    public void YV() {
        FrsActivity frsActivity;
        frsActivity = this.bHQ.bHh;
        frsActivity.XV();
    }

    @Override // com.baidu.tieba.tbadkCore.y.a
    public void YW() {
        BdExpandListView bdExpandListView;
        BdExpandListView bdExpandListView2;
        com.baidu.tieba.play.ac acVar;
        com.baidu.tieba.play.ac acVar2;
        int i;
        int i2;
        bdExpandListView = this.bHQ.bHo;
        if (bdExpandListView != null) {
            bdExpandListView2 = this.bHQ.bHo;
            bdExpandListView2.setSelection(0);
            acVar = this.bHQ.aLe;
            if (acVar != null) {
                acVar2 = this.bHQ.aLe;
                i = this.bHQ.aLi;
                i2 = this.bHQ.aLh;
                acVar2.a(i, i2, false, true);
            }
        }
    }
}
