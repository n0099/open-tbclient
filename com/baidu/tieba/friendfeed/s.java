package com.baidu.tieba.friendfeed;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements Runnable {
    final /* synthetic */ q aBe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(q qVar) {
        this.aBe = qVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aBe.praiseStopTime = System.currentTimeMillis();
    }
}
