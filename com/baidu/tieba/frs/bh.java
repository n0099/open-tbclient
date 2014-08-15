package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements Runnable {
    final /* synthetic */ bc a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(bc bcVar) {
        this.a = bcVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.n = System.currentTimeMillis();
    }
}
