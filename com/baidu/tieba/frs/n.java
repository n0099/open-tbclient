package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class n implements Runnable {
    final /* synthetic */ m aJH;
    private final /* synthetic */ String aJI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, String str) {
        this.aJH = mVar;
        this.aJI = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.util.aa aaVar = new com.baidu.tbadk.core.util.aa(this.aJI);
        aaVar.sp().tp().mIsNeedAddCommenParam = false;
        aaVar.sp().tp().mIsUseCurrentBDUSS = false;
        aaVar.rP();
    }
}
