package com.baidu.tieba.frs;

import java.util.ArrayList;
/* loaded from: classes.dex */
class i implements com.baidu.tieba.frs.mc.v {
    final /* synthetic */ FrsActivity bNU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FrsActivity frsActivity) {
        this.bNU = frsActivity;
    }

    @Override // com.baidu.tieba.frs.mc.v
    public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        com.baidu.tieba.frs.smartsort.c cVar;
        com.baidu.tieba.frs.smartsort.c cVar2;
        cVar = this.bNU.bNg;
        if (cVar != null && this.bNU.bMY != null && this.bNU.bMY.adc() && z && this.bNU.YL() && !z2) {
            cVar2 = this.bNU.bNg;
            cVar2.iq(i2);
        }
    }
}
