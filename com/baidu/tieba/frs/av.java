package com.baidu.tieba.frs;

import com.baidu.tieba.frs.FrsActivity;
/* loaded from: classes.dex */
class av implements Runnable {
    final /* synthetic */ FrsActivity.c bgP;
    private final /* synthetic */ String bgQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(FrsActivity.c cVar, String str) {
        this.bgP = cVar;
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
