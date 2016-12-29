package com.baidu.tieba;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ e aLf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aLf = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        d dVar;
        LogoActivity logoActivity;
        dVar = this.aLf.aLe;
        logoActivity = dVar.aLd;
        logoActivity.IE();
    }
}
