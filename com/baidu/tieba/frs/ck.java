package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ck implements Runnable {
    final /* synthetic */ cg aFl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ck(cg cgVar) {
        this.aFl = cgVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aFl.praiseStopTime = System.currentTimeMillis();
    }
}
