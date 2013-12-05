package com.baidu.tieba;
/* loaded from: classes.dex */
class am implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LogoActivity f1119a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(LogoActivity logoActivity) {
        this.f1119a = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1119a.releaseResouce();
        this.f1119a.a(this.f1119a.getBaseContext());
    }
}
