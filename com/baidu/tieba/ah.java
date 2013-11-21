package com.baidu.tieba;
/* loaded from: classes.dex */
class ah implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LogoActivity f1104a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(LogoActivity logoActivity) {
        this.f1104a = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1104a.releaseResouce();
        this.f1104a.a(this.f1104a.getBaseContext());
    }
}
