package com.baidu.tieba.frs;

import com.baidu.tieba.frs.FrsActivity;
/* loaded from: classes.dex */
class ah implements Runnable {
    final /* synthetic */ FrsActivity.a bNY;
    private final /* synthetic */ String bNZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(FrsActivity.a aVar, String str) {
        this.bNY = aVar;
        this.bNZ = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.util.z zVar = new com.baidu.tbadk.core.util.z(this.bNZ);
        zVar.uZ().vS().mIsNeedAddCommenParam = false;
        zVar.uZ().vS().mIsUseCurrentBDUSS = false;
        zVar.uC();
    }
}
