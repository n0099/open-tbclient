package com.baidu.tieba;
/* loaded from: classes.dex */
class ag implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LogoActivity f902a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(LogoActivity logoActivity) {
        this.f902a = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f902a.a_();
        this.f902a.a(this.f902a.getBaseContext());
    }
}
