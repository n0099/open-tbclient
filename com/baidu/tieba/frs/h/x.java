package com.baidu.tieba.frs.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements com.baidu.tieba.frs.entelechy.b.f {
    final /* synthetic */ w buD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.buD = wVar;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.f
    public void onOpened() {
        this.buD.onOpened();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.f
    public void onClosed() {
        this.buD.onClosed();
    }
}
