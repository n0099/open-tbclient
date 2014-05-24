package com.baidu.tieba.home;
/* loaded from: classes.dex */
class g implements Runnable {
    final /* synthetic */ f a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.a = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        e eVar;
        q qVar;
        eVar = this.a.a;
        qVar = eVar.b;
        qVar.b();
    }
}
