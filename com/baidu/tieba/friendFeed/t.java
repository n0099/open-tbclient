package com.baidu.tieba.friendFeed;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Runnable {
    final /* synthetic */ p aHY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(p pVar) {
        this.aHY = pVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aHY.praiseStopTime = System.currentTimeMillis();
    }
}
