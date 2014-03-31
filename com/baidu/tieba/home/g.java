package com.baidu.tieba.home;
/* loaded from: classes.dex */
final class g implements Runnable {
    final /* synthetic */ f a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.a = fVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        n nVar;
        nVar = this.a.a.a;
        nVar.a();
    }
}
