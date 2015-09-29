package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class q implements Runnable {
    final /* synthetic */ p aUA;
    private final /* synthetic */ String aUB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, String str) {
        this.aUA = pVar;
        this.aUB = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.util.w wVar = new com.baidu.tbadk.core.util.w(this.aUB);
        wVar.uh().uX().mIsNeedAddCommenParam = false;
        wVar.uh().uX().mIsUseCurrentBDUSS = false;
        wVar.tH();
    }
}
