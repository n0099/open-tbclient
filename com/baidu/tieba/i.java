package com.baidu.tieba;
/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ LogoActivity alk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(LogoActivity logoActivity) {
        this.alk = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.alk.releaseResouce();
        this.alk.ai(this.alk.getBaseContext());
    }
}
