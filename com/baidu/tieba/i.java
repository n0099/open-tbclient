package com.baidu.tieba;
/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ LogoActivity acU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(LogoActivity logoActivity) {
        this.acU = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.acU.releaseResouce();
        this.acU.L(this.acU.getBaseContext());
    }
}
