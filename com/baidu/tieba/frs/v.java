package com.baidu.tieba.frs;

import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements com.baidu.tieba.frs.mc.x {
    final /* synthetic */ r bPn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(r rVar) {
        this.bPn = rVar;
    }

    @Override // com.baidu.tieba.frs.mc.x
    public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        com.baidu.tieba.frs.smartsort.c cVar;
        com.baidu.tieba.frs.smartsort.c cVar2;
        cVar = this.bPn.bOC;
        if (cVar != null && this.bPn.bOw != null && this.bPn.bOw.acb() && z && !z2) {
            cVar2 = this.bPn.bOC;
            cVar2.io(i2);
        }
    }
}
