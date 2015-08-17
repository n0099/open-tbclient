package com.baidu.tieba.frs.frsgood;
/* loaded from: classes.dex */
class g implements Runnable {
    private final /* synthetic */ String aVm;
    final /* synthetic */ f aZq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, String str) {
        this.aZq = fVar;
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
