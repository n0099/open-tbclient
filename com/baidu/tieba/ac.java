package com.baidu.tieba;
/* loaded from: classes.dex */
final class ac implements Runnable {
    final /* synthetic */ LogoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(LogoActivity logoActivity) {
        this.a = logoActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.releaseResouce();
        LogoActivity logoActivity = this.a;
        this.a.getBaseContext();
        logoActivity.a();
    }
}
