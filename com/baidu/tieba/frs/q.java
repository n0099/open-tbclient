package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class q implements Runnable {
    final /* synthetic */ p aUT;
    private final /* synthetic */ String aUU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, String str) {
        this.aUT = pVar;
        this.aUU = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.util.w wVar = new com.baidu.tbadk.core.util.w(this.aUU);
        wVar.uh().uZ().mIsNeedAddCommenParam = false;
        wVar.uh().uZ().mIsUseCurrentBDUSS = false;
        wVar.tH();
    }
}
