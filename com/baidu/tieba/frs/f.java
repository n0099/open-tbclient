package com.baidu.tieba.frs;

import java.util.ArrayList;
/* loaded from: classes.dex */
class f implements com.baidu.tieba.frs.e.t {
    final /* synthetic */ FrsActivity bTa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(FrsActivity frsActivity) {
        this.bTa = frsActivity;
    }

    @Override // com.baidu.tieba.frs.e.t
    public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        com.baidu.tieba.frs.g.d dVar;
        com.baidu.tieba.frs.g.d dVar2;
        dVar = this.bTa.bSp;
        if (dVar != null && this.bTa.bSh != null && this.bTa.bSh.agD() && z && this.bTa.ach() && !z2) {
            dVar2 = this.bTa.bSp;
            dVar2.ix(i2);
        }
    }
}
