package com.baidu.tieba.frs;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class u implements Runnable {
    final /* synthetic */ FrsActivity aJG;
    private final /* synthetic */ long aJJ;
    private final /* synthetic */ long aJK;
    private final /* synthetic */ long aJL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(FrsActivity frsActivity, long j, long j2, long j3) {
        this.aJG = frsActivity;
        this.aJJ = j;
        this.aJK = j2;
        this.aJL = j3;
    }

    @Override // java.lang.Runnable
    public void run() {
        int M = com.baidu.adp.lib.util.n.M(this.aJG.getPageContext().getPageActivity());
        int N = com.baidu.adp.lib.util.n.N(this.aJG.getPageContext().getPageActivity());
        float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
        int i = 1;
        if (com.baidu.tbadk.core.util.be.sY().ta()) {
            i = 2;
        }
        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
        requestGetMyPostNetMessage.setParams(this.aJJ, this.aJK, this.aJL, M, N, f, i);
        this.aJG.sendMessage(requestGetMyPostNetMessage);
    }
}
