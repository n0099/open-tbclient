package com.baidu.tieba.frs;
/* loaded from: classes.dex */
final class o implements Runnable {
    final /* synthetic */ n a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, String str) {
        this.a = nVar;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.baidu.tbadk.core.util.ak akVar = new com.baidu.tbadk.core.util.ak(this.b);
        akVar.a().a().d = false;
        akVar.a().a().c = false;
        akVar.h();
    }
}
