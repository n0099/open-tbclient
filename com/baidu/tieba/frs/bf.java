package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf implements Runnable {
    final /* synthetic */ az a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(az azVar) {
        this.a = azVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.o = System.currentTimeMillis();
    }
}
