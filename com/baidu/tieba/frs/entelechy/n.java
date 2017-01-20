package com.baidu.tieba.frs.entelechy;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Runnable {
    final /* synthetic */ j bKz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(j jVar) {
        this.bKz = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bKz.Mn();
    }
}
