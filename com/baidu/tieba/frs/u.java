package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class u implements Runnable {
    final /* synthetic */ t aCW;
    private final /* synthetic */ String aCX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, String str) {
        this.aCW = tVar;
        this.aCX = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.util.ad adVar = new com.baidu.tbadk.core.util.ad(this.aCX);
        adVar.oW().pV().mIsNeedAddCommenParam = false;
        adVar.oW().pV().mIsUseCurrentBDUSS = false;
        adVar.ow();
    }
}
