package com.baidu.tieba.home;
/* loaded from: classes.dex */
class br implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bp f1481a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(bp bpVar) {
        this.f1481a = bpVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1481a.postDelayed(this, 2000L);
    }
}
