package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class q implements Runnable {
    final /* synthetic */ p aVl;
    private final /* synthetic */ String aVm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, String str) {
        this.aVl = pVar;
        this.aVm = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.util.v vVar = new com.baidu.tbadk.core.util.v(this.aVm);
        vVar.ue().uV().mIsNeedAddCommenParam = false;
        vVar.ue().uV().mIsUseCurrentBDUSS = false;
        vVar.tE();
    }
}
