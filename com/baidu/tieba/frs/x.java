package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class x implements Runnable {
    final /* synthetic */ w a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar, String str) {
        this.a = wVar;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        new com.baidu.tieba.d.w(this.b).l();
    }
}
