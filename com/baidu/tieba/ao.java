package com.baidu.tieba;
/* loaded from: classes.dex */
class ao implements Runnable {
    final /* synthetic */ LogoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(LogoActivity logoActivity) {
        this.a = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.releaseResouce();
        this.a.a(this.a.getBaseContext());
    }
}
