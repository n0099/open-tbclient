package com.baidu.tieba.frs.entelechy.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Runnable {
    final /* synthetic */ a bMu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(a aVar) {
        this.bMu = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bMu.Qm();
        this.bMu.e(true, 4);
    }
}
