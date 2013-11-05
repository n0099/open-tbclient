package com.baidu.tieba;
/* loaded from: classes.dex */
class ac implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LogoActivity f1005a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(LogoActivity logoActivity) {
        this.f1005a = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1005a.a_();
        this.f1005a.a(this.f1005a.getBaseContext());
    }
}
