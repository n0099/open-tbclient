package com.baidu.tieba;
/* loaded from: classes.dex */
class ae implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LogoActivity f687a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(LogoActivity logoActivity) {
        this.f687a = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f687a.a_();
        this.f687a.d();
    }
}
