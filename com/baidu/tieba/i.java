package com.baidu.tieba;
/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ LogoActivity akC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(LogoActivity logoActivity) {
        this.akC = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.akC.releaseResouce();
        this.akC.ai(this.akC.getBaseContext());
    }
}
