package com.baidu.tieba;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ g aHM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.aHM = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        f fVar;
        LogoActivity logoActivity;
        fVar = this.aHM.aHL;
        logoActivity = fVar.aHJ;
        logoActivity.HX();
    }
}
