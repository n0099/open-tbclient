package com.baidu.tieba.home;
/* loaded from: classes.dex */
class bw implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bu f1431a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(bu buVar) {
        this.f1431a = buVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1431a.postDelayed(this, 2000L);
    }
}
