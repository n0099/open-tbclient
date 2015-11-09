package com.baidu.tieba.frs.frsgood;
/* loaded from: classes.dex */
class g implements Runnable {
    private final /* synthetic */ String aUU;
    final /* synthetic */ f bag;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, String str) {
        this.bag = fVar;
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
