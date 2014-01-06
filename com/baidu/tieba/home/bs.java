package com.baidu.tieba.home;
/* loaded from: classes.dex */
class bs implements Runnable {
    final /* synthetic */ bq a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(bq bqVar) {
        this.a = bqVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.postDelayed(this, 2000L);
    }
}
