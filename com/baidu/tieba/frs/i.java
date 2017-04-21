package com.baidu.tieba.frs;

import java.util.ArrayList;
/* loaded from: classes.dex */
class i implements com.baidu.tieba.frs.mc.x {
    final /* synthetic */ FrsActivity bQa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FrsActivity frsActivity) {
        this.bQa = frsActivity;
    }

    @Override // com.baidu.tieba.frs.mc.x
    public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        com.baidu.tieba.frs.smartsort.c cVar;
        com.baidu.tieba.frs.smartsort.c cVar2;
        cVar = this.bQa.bPn;
        if (cVar != null && this.bQa.bPf != null && this.bQa.bPf.adX() && z && this.bQa.aai() && !z2) {
            cVar2 = this.bQa.bPn;
            cVar2.ix(i2);
        }
    }
}
