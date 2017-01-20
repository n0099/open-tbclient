package com.baidu.tieba;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ e aKh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aKh = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        d dVar;
        LogoActivity logoActivity;
        dVar = this.aKh.aKg;
        logoActivity = dVar.aKf;
        logoActivity.IQ();
    }
}
