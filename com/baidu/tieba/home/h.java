package com.baidu.tieba.home;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ g a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.a = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        f fVar;
        n nVar;
        fVar = this.a.a;
        nVar = fVar.b;
        nVar.e();
    }
}
