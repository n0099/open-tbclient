package com.baidu.tieba;
/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ h aIm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.aIm = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        g gVar;
        LogoActivity logoActivity;
        gVar = this.aIm.aIl;
        logoActivity = gVar.aIj;
        logoActivity.HM();
    }
}
