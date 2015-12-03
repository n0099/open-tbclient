package com.baidu.tieba;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ e aFl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aFl = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        d dVar;
        LogoActivity logoActivity;
        dVar = this.aFl.aFk;
        logoActivity = dVar.aFj;
        logoActivity.GI();
    }
}
