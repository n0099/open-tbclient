package com.baidu.tieba.frs.entelechy.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Runnable {
    final /* synthetic */ a bTp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(a aVar) {
        this.bTp = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bTp.RD();
        this.bTp.e(true, 4);
    }
}
