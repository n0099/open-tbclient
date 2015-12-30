package com.baidu.tieba.frs;

import com.baidu.tieba.frs.FrsActivity;
/* loaded from: classes.dex */
class at implements Runnable {
    final /* synthetic */ FrsActivity.c bev;
    private final /* synthetic */ String bew;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(FrsActivity.c cVar, String str) {
        this.bev = cVar;
        this.bew = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.util.ab abVar = new com.baidu.tbadk.core.util.ab(this.bew);
        abVar.uw().vp().mIsNeedAddCommenParam = false;
        abVar.uw().vp().mIsUseCurrentBDUSS = false;
        abVar.tW();
    }
}
