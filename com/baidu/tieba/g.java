package com.baidu.tieba;
/* loaded from: classes.dex */
class g implements Runnable {
    final /* synthetic */ LogoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(LogoActivity logoActivity) {
        this.a = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.releaseResouce();
        this.a.a(this.a.getBaseContext());
    }
}
