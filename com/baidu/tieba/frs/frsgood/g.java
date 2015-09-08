package com.baidu.tieba.frs.frsgood;
/* loaded from: classes.dex */
class g implements Runnable {
    private final /* synthetic */ String aVB;
    final /* synthetic */ f aZJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, String str) {
        this.aZJ = fVar;
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
