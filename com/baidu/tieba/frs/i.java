package com.baidu.tieba.frs;

import java.util.ArrayList;
/* loaded from: classes.dex */
class i implements com.baidu.tieba.frs.mc.x {
    final /* synthetic */ FrsActivity bNJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FrsActivity frsActivity) {
        this.bNJ = frsActivity;
    }

    @Override // com.baidu.tieba.frs.mc.x
    public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        com.baidu.tieba.frs.smartsort.c cVar;
        com.baidu.tieba.frs.smartsort.c cVar2;
        cVar = this.bNJ.bMW;
        if (cVar != null && this.bNJ.bMO != null && this.bNJ.bMO.acW() && z && this.bNJ.Zh() && !z2) {
            cVar2 = this.bNJ.bMW;
            cVar2.ir(i2);
        }
    }
}
