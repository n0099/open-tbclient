package com.baidu.tieba;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ g aLD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.aLD = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        f fVar;
        LogoActivity logoActivity;
        fVar = this.aLD.aLC;
        logoActivity = fVar.aLA;
        logoActivity.Jg();
    }
}
