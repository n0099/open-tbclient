package com.baidu.tieba.frs;

import com.baidu.tieba.frs.FrsActivity;
/* loaded from: classes.dex */
class at implements Runnable {
    final /* synthetic */ FrsActivity.b bEV;
    private final /* synthetic */ String bEW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(FrsActivity.b bVar, String str) {
        this.bEV = bVar;
        this.bEW = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.util.ab abVar = new com.baidu.tbadk.core.util.ab(this.bEW);
        abVar.tx().uu().mIsNeedAddCommenParam = false;
        abVar.tx().uu().mIsUseCurrentBDUSS = false;
        abVar.ta();
    }
}
