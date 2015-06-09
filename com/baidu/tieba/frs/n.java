package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class n implements Runnable {
    final /* synthetic */ m aLZ;
    private final /* synthetic */ String aMa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, String str) {
        this.aLZ = mVar;
        this.aMa = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.util.aa aaVar = new com.baidu.tbadk.core.util.aa(this.aMa);
        aaVar.sX().tS().mIsNeedAddCommenParam = false;
        aaVar.sX().tS().mIsUseCurrentBDUSS = false;
        aaVar.sx();
    }
}
