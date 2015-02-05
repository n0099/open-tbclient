package com.baidu.tieba.friendfeed;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements Runnable {
    final /* synthetic */ p aCc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar) {
        this.aCc = pVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aCc.praiseStopTime = System.currentTimeMillis();
    }
}
