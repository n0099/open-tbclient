package com.baidu.tieba;
/* loaded from: classes.dex */
class ae implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LogoActivity f1098a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(LogoActivity logoActivity) {
        this.f1098a = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1098a.releaseResouce();
        this.f1098a.a(this.f1098a.getBaseContext());
    }
}
