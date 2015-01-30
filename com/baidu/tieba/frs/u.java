package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class u implements Runnable {
    final /* synthetic */ t aDX;
    private final /* synthetic */ String aDY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, String str) {
        this.aDX = tVar;
        this.aDY = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.util.ad adVar = new com.baidu.tbadk.core.util.ad(this.aDY);
        adVar.oZ().qg().mIsNeedAddCommenParam = false;
        adVar.oZ().qg().mIsUseCurrentBDUSS = false;
        adVar.oz();
    }
}
