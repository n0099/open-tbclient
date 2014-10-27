package com.baidu.tieba;
/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ LogoActivity acP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(LogoActivity logoActivity) {
        this.acP = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.acP.releaseResouce();
        this.acP.L(this.acP.getBaseContext());
    }
}
