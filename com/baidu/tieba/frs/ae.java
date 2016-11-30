package com.baidu.tieba.frs;

import com.baidu.tieba.frs.FrsActivity;
/* loaded from: classes.dex */
class ae implements Runnable {
    final /* synthetic */ FrsActivity.a bTe;
    private final /* synthetic */ String bTf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(FrsActivity.a aVar, String str) {
        this.bTe = aVar;
        this.bTf = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.util.z zVar = new com.baidu.tbadk.core.util.z(this.bTf);
        zVar.uW().vR().mIsNeedAddCommenParam = false;
        zVar.uW().vR().mIsUseCurrentBDUSS = false;
        zVar.uz();
    }
}
