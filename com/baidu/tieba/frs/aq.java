package com.baidu.tieba.frs;

import com.baidu.tieba.frs.FrsActivity;
/* loaded from: classes.dex */
class aq implements Runnable {
    final /* synthetic */ FrsActivity.c baw;
    private final /* synthetic */ String bax;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(FrsActivity.c cVar, String str) {
        this.baw = cVar;
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
