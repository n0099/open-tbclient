package com.baidu.tieba;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ e aLO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aLO = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        d dVar;
        LogoActivity logoActivity;
        dVar = this.aLO.aLN;
        logoActivity = dVar.aLM;
        logoActivity.Jj();
    }
}
