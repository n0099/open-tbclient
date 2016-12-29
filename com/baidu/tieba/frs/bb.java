package com.baidu.tieba.frs;

import com.baidu.tieba.tbadkCore.aa;
import com.baidu.tieba.view.BdExpandListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements aa.a {
    final /* synthetic */ ax bAv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(ax axVar) {
        this.bAv = axVar;
    }

    @Override // com.baidu.tieba.tbadkCore.aa.a
    public void XO() {
        FrsActivity frsActivity;
        frsActivity = this.bAv.bzH;
        frsActivity.WE();
    }

    @Override // com.baidu.tieba.tbadkCore.aa.a
    public void XP() {
        BdExpandListView bdExpandListView;
        BdExpandListView bdExpandListView2;
        com.baidu.tieba.play.aa aaVar;
        com.baidu.tieba.play.aa aaVar2;
        int i;
        int i2;
        bdExpandListView = this.bAv.bzO;
        if (bdExpandListView != null) {
            bdExpandListView2 = this.bAv.bzO;
            bdExpandListView2.setSelection(0);
            aaVar = this.bAv.aMd;
            if (aaVar != null) {
                aaVar2 = this.bAv.aMd;
                i = this.bAv.aMh;
                i2 = this.bAv.aMg;
                aaVar2.a(i, i2, false, true);
            }
        }
    }
}
