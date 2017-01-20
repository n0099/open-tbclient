package com.baidu.tieba.frs;

import com.baidu.tieba.frs.FrsActivity;
/* loaded from: classes.dex */
class ah implements Runnable {
    final /* synthetic */ FrsActivity.a bGP;
    private final /* synthetic */ String bGQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(FrsActivity.a aVar, String str) {
        this.bGP = aVar;
        this.bGQ = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.util.y yVar = new com.baidu.tbadk.core.util.y(this.bGQ);
        yVar.uC().vv().mIsNeedAddCommenParam = false;
        yVar.uC().vv().mIsUseCurrentBDUSS = false;
        yVar.ue();
    }
}
