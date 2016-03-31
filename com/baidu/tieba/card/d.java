package com.baidu.tieba.card;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements a.b {
    private final /* synthetic */ int WS;
    final /* synthetic */ c aRM;
    private final /* synthetic */ com.baidu.tbadk.core.data.c aRN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, com.baidu.tbadk.core.data.c cVar2, int i) {
        this.aRM = cVar;
        this.aRN = cVar2;
        this.WS = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        if (!this.aRN.rl()) {
            return;
        }
        this.aRM.b(this.aRN, this.WS);
        aVar.dismiss();
    }
}
