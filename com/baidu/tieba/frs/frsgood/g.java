package com.baidu.tieba.frs.frsgood;
/* loaded from: classes.dex */
class g implements Runnable {
    private final /* synthetic */ String aUB;
    final /* synthetic */ f aZC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, String str) {
        this.aZC = fVar;
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
