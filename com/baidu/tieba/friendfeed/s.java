package com.baidu.tieba.friendfeed;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements Runnable {
    final /* synthetic */ q azg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(q qVar) {
        this.azg = qVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.azg.azc = System.currentTimeMillis();
    }
}
