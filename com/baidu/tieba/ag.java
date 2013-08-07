package com.baidu.tieba;
/* loaded from: classes.dex */
class ag implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LogoActivity f900a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(LogoActivity logoActivity) {
        this.f900a = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f900a.a_();
        this.f900a.a(this.f900a.getBaseContext());
    }
}
