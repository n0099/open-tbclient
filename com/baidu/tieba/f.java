package com.baidu.tieba;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ e aGL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aGL = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        d dVar;
        LogoActivity logoActivity;
        dVar = this.aGL.aGK;
        logoActivity = dVar.aGJ;
        logoActivity.Gx();
    }
}
