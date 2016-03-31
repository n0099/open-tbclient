package com.baidu.tieba.frs;

import com.baidu.tieba.frs.FrsActivity;
/* loaded from: classes.dex */
class aw implements Runnable {
    final /* synthetic */ FrsActivity.c blA;
    private final /* synthetic */ String blB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(FrsActivity.c cVar, String str) {
        this.blA = cVar;
        this.blB = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.util.ab abVar = new com.baidu.tbadk.core.util.ab(this.blB);
        abVar.vU().wO().mIsNeedAddCommenParam = false;
        abVar.vU().wO().mIsUseCurrentBDUSS = false;
        abVar.vx();
    }
}
