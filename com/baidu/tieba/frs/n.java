package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class n implements Runnable {
    final /* synthetic */ m a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, String str) {
        this.a = mVar;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq(this.b);
        aqVar.a().a().d = false;
        aqVar.a().a().c = false;
        aqVar.h();
    }
}
