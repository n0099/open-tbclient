package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class q implements Runnable {
    final /* synthetic */ p aUL;
    private final /* synthetic */ String aUM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, String str) {
        this.aUL = pVar;
        this.aUM = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.util.w wVar = new com.baidu.tbadk.core.util.w(this.aUM);
        wVar.uh().uY().mIsNeedAddCommenParam = false;
        wVar.uh().uY().mIsUseCurrentBDUSS = false;
        wVar.tH();
    }
}
