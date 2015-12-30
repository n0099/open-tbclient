package com.baidu.tieba.frs.frsgood;
/* loaded from: classes.dex */
class g implements Runnable {
    private final /* synthetic */ String bew;
    final /* synthetic */ f bkq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, String str) {
        this.bkq = fVar;
        this.bew = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.util.ab abVar = new com.baidu.tbadk.core.util.ab(this.bew);
        abVar.uw().vp().mIsNeedAddCommenParam = false;
        abVar.uw().vp().mIsUseCurrentBDUSS = false;
        abVar.tW();
    }
}
