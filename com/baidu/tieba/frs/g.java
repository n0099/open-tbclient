package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class g implements Runnable {
    final /* synthetic */ f a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, String str) {
        this.a = fVar;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        new com.baidu.tieba.c.w(this.b).l();
    }
}
