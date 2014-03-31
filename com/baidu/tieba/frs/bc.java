package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bc implements Runnable {
    final /* synthetic */ ay a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(ay ayVar) {
        this.a = ayVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.q = System.currentTimeMillis();
    }
}
