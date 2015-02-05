package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cj implements Runnable {
    final /* synthetic */ cf aGq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(cf cfVar) {
        this.aGq = cfVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aGq.praiseStopTime = System.currentTimeMillis();
    }
}
