package com.baidu.tieba.card;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements a.b {
    private final /* synthetic */ int YA;
    final /* synthetic */ c aOW;
    private final /* synthetic */ com.baidu.tbadk.core.data.c aOX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, com.baidu.tbadk.core.data.c cVar2, int i) {
        this.aOW = cVar;
        this.aOX = cVar2;
        this.YA = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        if (!this.aOX.rN()) {
            return;
        }
        this.aOW.b(this.aOX, this.YA);
        aVar.dismiss();
    }
}
