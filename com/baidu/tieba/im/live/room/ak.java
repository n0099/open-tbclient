package com.baidu.tieba.im.live.room;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements Runnable {
    final /* synthetic */ ag a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ag agVar) {
        this.a = agVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.x = System.currentTimeMillis();
    }
}
