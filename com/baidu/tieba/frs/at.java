package com.baidu.tieba.frs;

import com.baidu.tieba.frs.FrsActivity;
/* loaded from: classes.dex */
class at implements Runnable {
    final /* synthetic */ FrsActivity.b bQs;
    private final /* synthetic */ String bQt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(FrsActivity.b bVar, String str) {
        this.bQs = bVar;
        this.bQt = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.util.ab abVar = new com.baidu.tbadk.core.util.ab(this.bQt);
        abVar.uS().vN().mIsNeedAddCommenParam = false;
        abVar.uS().vN().mIsUseCurrentBDUSS = false;
        abVar.uv();
    }
}
