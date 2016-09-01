package com.baidu.tieba.frs;

import com.baidu.tieba.frs.FrsActivity;
/* loaded from: classes.dex */
class at implements Runnable {
    private final /* synthetic */ String bQA;
    final /* synthetic */ FrsActivity.b bQz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(FrsActivity.b bVar, String str) {
        this.bQz = bVar;
        this.bQA = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.util.ab abVar = new com.baidu.tbadk.core.util.ab(this.bQA);
        abVar.uD().vz().mIsNeedAddCommenParam = false;
        abVar.uD().vz().mIsUseCurrentBDUSS = false;
        abVar.uf();
    }
}
