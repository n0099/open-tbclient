package com.baidu.tieba.frs.entelechy.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ a bKn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(a aVar) {
        this.bKn = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bKn.KY();
        this.bKn.d(true, 4);
    }
}
