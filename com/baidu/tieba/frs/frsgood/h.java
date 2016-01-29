package com.baidu.tieba.frs.frsgood;
/* loaded from: classes.dex */
class h implements Runnable {
    private final /* synthetic */ String bgQ;
    final /* synthetic */ g bnn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar, String str) {
        this.bnn = gVar;
        this.bgQ = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.util.aa aaVar = new com.baidu.tbadk.core.util.aa(this.bgQ);
        aaVar.vB().wv().mIsNeedAddCommenParam = false;
        aaVar.vB().wv().mIsUseCurrentBDUSS = false;
        aaVar.va();
    }
}
