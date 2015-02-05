package com.baidu.tieba;
/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ LogoActivity alh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(LogoActivity logoActivity) {
        this.alh = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.alh.releaseResouce();
        this.alh.ai(this.alh.getBaseContext());
    }
}
