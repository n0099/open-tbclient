package com.baidu.tieba.card;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.b {
    private final /* synthetic */ int Sg;
    final /* synthetic */ f aOt;
    private final /* synthetic */ com.baidu.tbadk.core.data.c aOu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, com.baidu.tbadk.core.data.c cVar, int i) {
        this.aOt = fVar;
        this.aOu = cVar;
        this.Sg = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        if (!this.aOu.oG()) {
            return;
        }
        this.aOt.c(this.aOu, this.Sg);
        aVar.dismiss();
    }
}
