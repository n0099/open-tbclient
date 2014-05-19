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
        com.baidu.tbadk.core.util.al alVar = new com.baidu.tbadk.core.util.al(this.b);
        alVar.a().a().d = false;
        alVar.a().a().c = false;
        alVar.h();
    }
}
