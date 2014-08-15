package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class o implements Runnable {
    final /* synthetic */ n a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, String str) {
        this.a = nVar;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.util.ae aeVar = new com.baidu.tbadk.core.util.ae(this.b);
        aeVar.a().a().d = false;
        aeVar.a().a().c = false;
        aeVar.g();
    }
}
