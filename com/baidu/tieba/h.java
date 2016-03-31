package com.baidu.tieba;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ g aKI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.aKI = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        f fVar;
        LogoActivity logoActivity;
        fVar = this.aKI.aKH;
        logoActivity = fVar.aKF;
        logoActivity.Jt();
    }
}
