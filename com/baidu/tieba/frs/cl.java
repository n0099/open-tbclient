package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cl implements Runnable {
    final /* synthetic */ cj aDK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(cj cjVar) {
        this.aDK = cjVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aDK.azc = System.currentTimeMillis();
    }
}
