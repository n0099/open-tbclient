package com.baidu.tieba.frs;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class u implements Runnable {
    final /* synthetic */ FrsActivity aJQ;
    private final /* synthetic */ long aJT;
    private final /* synthetic */ long aJU;
    private final /* synthetic */ long aJV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(FrsActivity frsActivity, long j, long j2, long j3) {
        this.aJQ = frsActivity;
        this.aJT = j;
        this.aJU = j2;
        this.aJV = j3;
    }

    @Override // java.lang.Runnable
    public void run() {
        int M = com.baidu.adp.lib.util.n.M(this.aJQ.getPageContext().getPageActivity());
        int N = com.baidu.adp.lib.util.n.N(this.aJQ.getPageContext().getPageActivity());
        float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
        int i = 1;
        if (com.baidu.tbadk.core.util.be.sY().ta()) {
            i = 2;
        }
        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
        requestGetMyPostNetMessage.setParams(this.aJT, this.aJU, this.aJV, M, N, f, i);
        this.aJQ.sendMessage(requestGetMyPostNetMessage);
    }
}
