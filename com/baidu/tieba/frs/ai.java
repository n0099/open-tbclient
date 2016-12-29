package com.baidu.tieba.frs;

import com.baidu.tieba.frs.FrsActivity;
/* loaded from: classes.dex */
class ai implements Runnable {
    final /* synthetic */ FrsActivity.a bzp;
    private final /* synthetic */ String bzq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(FrsActivity.a aVar, String str) {
        this.bzp = aVar;
        this.bzq = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.util.z zVar = new com.baidu.tbadk.core.util.z(this.bzq);
        zVar.uI().vB().mIsNeedAddCommenParam = false;
        zVar.uI().vB().mIsUseCurrentBDUSS = false;
        zVar.ul();
    }
}
