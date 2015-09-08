package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class q implements Runnable {
    final /* synthetic */ p aVA;
    private final /* synthetic */ String aVB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, String str) {
        this.aVA = pVar;
        this.aVB = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.util.v vVar = new com.baidu.tbadk.core.util.v(this.aVB);
        vVar.uj().uZ().mIsNeedAddCommenParam = false;
        vVar.uj().uZ().mIsUseCurrentBDUSS = false;
        vVar.tJ();
    }
}
