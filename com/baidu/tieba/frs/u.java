package com.baidu.tieba.frs;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class u implements Runnable {
    final /* synthetic */ FrsActivity aLY;
    private final /* synthetic */ long aMb;
    private final /* synthetic */ long aMc;
    private final /* synthetic */ long aMd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(FrsActivity frsActivity, long j, long j2, long j3) {
        this.aLY = frsActivity;
        this.aMb = j;
        this.aMc = j2;
        this.aMd = j3;
    }

    @Override // java.lang.Runnable
    public void run() {
        int M = com.baidu.adp.lib.util.n.M(this.aLY.getPageContext().getPageActivity());
        int N = com.baidu.adp.lib.util.n.N(this.aLY.getPageContext().getPageActivity());
        float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
        int i = 1;
        if (com.baidu.tbadk.core.util.bc.tB().tD()) {
            i = 2;
        }
        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
        requestGetMyPostNetMessage.setParams(this.aMb, this.aMc, this.aMd, M, N, f, i);
        this.aLY.sendMessage(requestGetMyPostNetMessage);
    }
}
