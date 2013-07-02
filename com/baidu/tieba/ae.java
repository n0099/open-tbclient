package com.baidu.tieba;
/* loaded from: classes.dex */
class ae implements Runnable {
    final /* synthetic */ LogoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(LogoActivity logoActivity) {
        this.a = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.a_();
        this.a.d();
    }
}
