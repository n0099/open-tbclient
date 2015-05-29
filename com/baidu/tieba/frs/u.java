package com.baidu.tieba.frs;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class u implements Runnable {
    final /* synthetic */ FrsActivity aLX;
    private final /* synthetic */ long aMa;
    private final /* synthetic */ long aMb;
    private final /* synthetic */ long aMc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(FrsActivity frsActivity, long j, long j2, long j3) {
        this.aLX = frsActivity;
        this.aMa = j;
        this.aMb = j2;
        this.aMc = j3;
    }

    @Override // java.lang.Runnable
    public void run() {
        int M = com.baidu.adp.lib.util.n.M(this.aLX.getPageContext().getPageActivity());
        int N = com.baidu.adp.lib.util.n.N(this.aLX.getPageContext().getPageActivity());
        float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
        int i = 1;
        if (com.baidu.tbadk.core.util.bc.tB().tD()) {
            i = 2;
        }
        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
        requestGetMyPostNetMessage.setParams(this.aMa, this.aMb, this.aMc, M, N, f, i);
        this.aLX.sendMessage(requestGetMyPostNetMessage);
    }
}
