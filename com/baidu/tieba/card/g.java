package com.baidu.tieba.card;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.b {
    private final /* synthetic */ int Tf;
    final /* synthetic */ f aSK;
    private final /* synthetic */ com.baidu.tbadk.core.data.b aSL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, com.baidu.tbadk.core.data.b bVar, int i) {
        this.aSK = fVar;
        this.aSL = bVar;
        this.Tf = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        if (!this.aSL.ol()) {
            return;
        }
        this.aSK.c(this.aSL, this.Tf);
        aVar.dismiss();
    }
}
