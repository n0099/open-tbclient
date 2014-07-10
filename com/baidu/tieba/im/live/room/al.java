package com.baidu.tieba.im.live.room;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements Runnable {
    final /* synthetic */ ah a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ah ahVar) {
        this.a = ahVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.x = System.currentTimeMillis();
    }
}
