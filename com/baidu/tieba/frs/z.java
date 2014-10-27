package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class z implements Runnable {
    final /* synthetic */ y aBl;
    private final /* synthetic */ String aBm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar, String str) {
        this.aBl = yVar;
        this.aBm = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.util.ac acVar = new com.baidu.tbadk.core.util.ac(this.aBm);
        acVar.mc().na().mIsNeedAddCommenParam = false;
        acVar.mc().na().mIsUseCurrentBDUSS = false;
        acVar.lB();
    }
}
