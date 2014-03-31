package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bb implements Runnable {
    final /* synthetic */ ay a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(ay ayVar) {
        this.a = ayVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.q = System.currentTimeMillis();
    }
}
