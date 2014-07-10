package com.baidu.tieba.im.live.room;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements Runnable {
    final /* synthetic */ ah a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ah ahVar) {
        this.a = ahVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.x = System.currentTimeMillis();
    }
}
