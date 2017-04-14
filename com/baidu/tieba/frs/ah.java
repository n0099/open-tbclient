package com.baidu.tieba.frs;

import com.baidu.tieba.frs.FrsActivity;
/* loaded from: classes.dex */
class ah implements Runnable {
    final /* synthetic */ FrsActivity.a bNN;
    private final /* synthetic */ String bNO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(FrsActivity.a aVar, String str) {
        this.bNN = aVar;
        this.bNO = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.util.z zVar = new com.baidu.tbadk.core.util.z(this.bNO);
        zVar.vw().wp().mIsNeedAddCommenParam = false;
        zVar.vw().wp().mIsUseCurrentBDUSS = false;
        zVar.uZ();
    }
}
