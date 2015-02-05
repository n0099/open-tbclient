package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class u implements Runnable {
    final /* synthetic */ t aDU;
    private final /* synthetic */ String aDV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, String str) {
        this.aDU = tVar;
        this.aDV = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.util.ad adVar = new com.baidu.tbadk.core.util.ad(this.aDV);
        adVar.oS().pZ().mIsNeedAddCommenParam = false;
        adVar.oS().pZ().mIsUseCurrentBDUSS = false;
        adVar.os();
    }
}
