package com.baidu.tieba.frs;

import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements com.baidu.tieba.frs.mc.x {
    final /* synthetic */ r bVb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(r rVar) {
        this.bVb = rVar;
    }

    @Override // com.baidu.tieba.frs.mc.x
    public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        com.baidu.tieba.frs.smartsort.c cVar;
        com.baidu.tieba.frs.smartsort.c cVar2;
        cVar = this.bVb.bUp;
        if (cVar != null && this.bVb.bUj != null && this.bVb.bUj.adf() && z && !z2) {
            cVar2 = this.bVb.bUp;
            cVar2.iM(i2);
        }
    }
}
