package com.baidu.tieba.frs;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class y implements Runnable {
    private final /* synthetic */ long aVC;
    private final /* synthetic */ long aVD;
    private final /* synthetic */ long aVE;
    final /* synthetic */ FrsActivity aVz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(FrsActivity frsActivity, long j, long j2, long j3) {
        this.aVz = frsActivity;
        this.aVC = j;
        this.aVD = j2;
        this.aVE = j3;
    }

    @Override // java.lang.Runnable
    public void run() {
        int K = com.baidu.adp.lib.util.k.K(this.aVz.getPageContext().getPageActivity());
        int L = com.baidu.adp.lib.util.k.L(this.aVz.getPageContext().getPageActivity());
        float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
        int i = 1;
        if (com.baidu.tbadk.core.util.ar.uK().uM()) {
            i = 2;
        }
        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
        requestGetMyPostNetMessage.setParams(this.aVC, this.aVD, this.aVE, K, L, f, i);
        this.aVz.sendMessage(requestGetMyPostNetMessage);
    }
}
