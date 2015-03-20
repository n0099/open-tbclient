package com.baidu.tieba;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ LogoActivity atC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(LogoActivity logoActivity) {
        this.atC = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.atC.releaseResouce();
        this.atC.al(this.atC.getBaseContext());
    }
}
