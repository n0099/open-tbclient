package com.baidu.tieba.frs.entelechy;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Runnable {
    final /* synthetic */ j bVg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(j jVar) {
        this.bVg = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bVg.add();
    }
}
