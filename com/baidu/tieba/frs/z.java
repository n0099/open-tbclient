package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class z implements Runnable {
    final /* synthetic */ y aBv;
    private final /* synthetic */ String aBw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar, String str) {
        this.aBv = yVar;
        this.aBw = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.util.ac acVar = new com.baidu.tbadk.core.util.ac(this.aBw);
        acVar.mc().na().mIsNeedAddCommenParam = false;
        acVar.mc().na().mIsUseCurrentBDUSS = false;
        acVar.lB();
    }
}
