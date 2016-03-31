package com.baidu.tieba.frs.frsgood;
/* loaded from: classes.dex */
class h implements Runnable {
    private final /* synthetic */ String blB;
    final /* synthetic */ g bsk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar, String str) {
        this.bsk = gVar;
        this.blB = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.util.ab abVar = new com.baidu.tbadk.core.util.ab(this.blB);
        abVar.vU().wO().mIsNeedAddCommenParam = false;
        abVar.vU().wO().mIsUseCurrentBDUSS = false;
        abVar.vx();
    }
}
