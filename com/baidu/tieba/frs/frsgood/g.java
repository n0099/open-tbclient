package com.baidu.tieba.frs.frsgood;
/* loaded from: classes.dex */
class g implements Runnable {
    private final /* synthetic */ String bax;
    final /* synthetic */ f bgz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, String str) {
        this.bgz = fVar;
        this.bax = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.util.ab abVar = new com.baidu.tbadk.core.util.ab(this.bax);
        abVar.uM().vF().mIsNeedAddCommenParam = false;
        abVar.uM().vF().mIsUseCurrentBDUSS = false;
        abVar.um();
    }
}
