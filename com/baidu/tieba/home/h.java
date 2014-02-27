package com.baidu.tieba.home;
/* loaded from: classes.dex */
final class h implements Runnable {
    final /* synthetic */ g a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.a = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        n nVar;
        nVar = this.a.a.b;
        nVar.a();
    }
}
