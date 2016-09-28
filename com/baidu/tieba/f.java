package com.baidu.tieba;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ e aKX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aKX = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        d dVar;
        LogoActivity logoActivity;
        dVar = this.aKX.aKW;
        logoActivity = dVar.aKV;
        logoActivity.Jg();
    }
}
