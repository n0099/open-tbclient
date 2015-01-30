package com.baidu.tieba.friendfeed;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements Runnable {
    final /* synthetic */ p aCf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar) {
        this.aCf = pVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aCf.praiseStopTime = System.currentTimeMillis();
    }
}
