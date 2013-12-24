package com.baidu.tieba.home;
/* loaded from: classes.dex */
class br implements Runnable {
    final /* synthetic */ bp a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(bp bpVar) {
        this.a = bpVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.postDelayed(this, 2000L);
    }
}
