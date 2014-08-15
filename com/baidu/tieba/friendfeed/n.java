package com.baidu.tieba.friendfeed;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Runnable {
    final /* synthetic */ l a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar) {
        this.a = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.j = System.currentTimeMillis();
    }
}
