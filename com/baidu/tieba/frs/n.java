package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class n implements Runnable {
    final /* synthetic */ m aJR;
    private final /* synthetic */ String aJS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, String str) {
        this.aJR = mVar;
        this.aJS = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.util.aa aaVar = new com.baidu.tbadk.core.util.aa(this.aJS);
        aaVar.sp().tp().mIsNeedAddCommenParam = false;
        aaVar.sp().tp().mIsUseCurrentBDUSS = false;
        aaVar.rP();
    }
}
