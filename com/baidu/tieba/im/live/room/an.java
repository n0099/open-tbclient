package com.baidu.tieba.im.live.room;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements Runnable {
    final /* synthetic */ aj a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(aj ajVar) {
        this.a = ajVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.v = System.currentTimeMillis();
    }
}
