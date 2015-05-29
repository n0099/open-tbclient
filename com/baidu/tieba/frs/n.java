package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class n implements Runnable {
    final /* synthetic */ m aLY;
    private final /* synthetic */ String aLZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, String str) {
        this.aLY = mVar;
        this.aLZ = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.util.aa aaVar = new com.baidu.tbadk.core.util.aa(this.aLZ);
        aaVar.sX().tS().mIsNeedAddCommenParam = false;
        aaVar.sX().tS().mIsUseCurrentBDUSS = false;
        aaVar.sx();
    }
}
