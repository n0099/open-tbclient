package com.baidu.tieba.frs.entelechy.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {
    final /* synthetic */ a bLV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(a aVar) {
        this.bLV = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bLV.KX();
        this.bLV.e(true, 4);
    }
}
