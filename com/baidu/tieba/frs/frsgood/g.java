package com.baidu.tieba.frs.frsgood;
/* loaded from: classes.dex */
class g implements Runnable {
    private final /* synthetic */ String aUM;
    final /* synthetic */ f aZN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, String str) {
        this.aZN = fVar;
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
