package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ck implements Runnable {
    final /* synthetic */ cf aGt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ck(cf cfVar) {
        this.aGt = cfVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aGt.praiseStopTime = System.currentTimeMillis();
    }
}
