package com.baidu.tieba.frs;

import com.baidu.tieba.frs.FrsActivity;
/* loaded from: classes.dex */
class ax implements Runnable {
    final /* synthetic */ FrsActivity.b bhD;
    private final /* synthetic */ String bhE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(FrsActivity.b bVar, String str) {
        this.bhD = bVar;
        this.bhE = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.util.ab abVar = new com.baidu.tbadk.core.util.ab(this.bhE);
        abVar.tB().uv().mIsNeedAddCommenParam = false;
        abVar.tB().uv().mIsUseCurrentBDUSS = false;
        abVar.te();
    }
}
