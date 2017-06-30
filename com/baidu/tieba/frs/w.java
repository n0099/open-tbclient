package com.baidu.tieba.frs;

import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements com.baidu.tieba.frs.mc.aa {
    final /* synthetic */ r cdl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(r rVar) {
        this.cdl = rVar;
    }

    @Override // com.baidu.tieba.frs.mc.aa
    public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        com.baidu.tieba.frs.smartsort.c cVar;
        com.baidu.tieba.frs.smartsort.c cVar2;
        cVar = this.cdl.ccx;
        if (cVar != null && this.cdl.ccs != null && this.cdl.ccs.agY() && z && !z2) {
            cVar2 = this.cdl.ccx;
            cVar2.iY(i2);
        }
    }
}
