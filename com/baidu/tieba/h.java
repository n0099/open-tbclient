package com.baidu.tieba;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ g aGT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.aGT = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        f fVar;
        LogoActivity logoActivity;
        fVar = this.aGT.aGS;
        logoActivity = fVar.aGQ;
        logoActivity.HK();
    }
}
