package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements Runnable {
    final /* synthetic */ bd a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(bd bdVar) {
        this.a = bdVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.n = System.currentTimeMillis();
    }
}
