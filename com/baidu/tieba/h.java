package com.baidu.tieba;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ LogoActivity atK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(LogoActivity logoActivity) {
        this.atK = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.atK.releaseResouce();
        this.atK.al(this.atK.getBaseContext());
    }
}
