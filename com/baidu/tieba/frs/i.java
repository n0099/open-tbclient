package com.baidu.tieba.frs;

import java.util.ArrayList;
/* loaded from: classes.dex */
class i implements com.baidu.tieba.frs.mc.s {
    final /* synthetic */ FrsActivity bGL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FrsActivity frsActivity) {
        this.bGL = frsActivity;
    }

    @Override // com.baidu.tieba.frs.mc.s
    public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        com.baidu.tieba.frs.smartsort.c cVar;
        com.baidu.tieba.frs.smartsort.c cVar2;
        cVar = this.bGL.bFY;
        if (cVar != null && this.bGL.bFQ != null && this.bGL.bFQ.acf() && z && this.bGL.XM() && !z2) {
            cVar2 = this.bGL.bFY;
            cVar2.iu(i2);
        }
    }
}
