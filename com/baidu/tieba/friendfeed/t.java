package com.baidu.tieba.friendfeed;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Runnable {
    final /* synthetic */ q ayX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(q qVar) {
        this.ayX = qVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ayX.ayT = System.currentTimeMillis();
    }
}
