package com.baidu.tieba.card;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.b {
    private final /* synthetic */ int Sx;
    final /* synthetic */ f aRQ;
    private final /* synthetic */ com.baidu.tbadk.core.data.b aRR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, com.baidu.tbadk.core.data.b bVar, int i) {
        this.aRQ = fVar;
        this.aRR = bVar;
        this.Sx = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        if (!this.aRR.ow()) {
            return;
        }
        this.aRQ.c(this.aRR, this.Sx);
        aVar.dismiss();
    }
}
