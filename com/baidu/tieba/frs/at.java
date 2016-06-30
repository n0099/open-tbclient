package com.baidu.tieba.frs;

import com.baidu.tieba.frs.FrsActivity;
/* loaded from: classes.dex */
class at implements Runnable {
    final /* synthetic */ FrsActivity.b bDL;
    private final /* synthetic */ String bDM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(FrsActivity.b bVar, String str) {
        this.bDL = bVar;
        this.bDM = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.util.ab abVar = new com.baidu.tbadk.core.util.ab(this.bDM);
        abVar.ty().uu().mIsNeedAddCommenParam = false;
        abVar.ty().uu().mIsUseCurrentBDUSS = false;
        abVar.tb();
    }
}
