package com.baidu.tieba.frs;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class y implements Runnable {
    final /* synthetic */ FrsActivity aUS;
    private final /* synthetic */ long aUV;
    private final /* synthetic */ long aUW;
    private final /* synthetic */ long aUX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(FrsActivity frsActivity, long j, long j2, long j3) {
        this.aUS = frsActivity;
        this.aUV = j;
        this.aUW = j2;
        this.aUX = j3;
    }

    @Override // java.lang.Runnable
    public void run() {
        int K = com.baidu.adp.lib.util.k.K(this.aUS.getPageContext().getPageActivity());
        int L = com.baidu.adp.lib.util.k.L(this.aUS.getPageContext().getPageActivity());
        float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
        int i = 1;
        if (com.baidu.tbadk.core.util.at.uK().uM()) {
            i = 2;
        }
        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
        requestGetMyPostNetMessage.setParams(this.aUV, this.aUW, this.aUX, K, L, f, i);
        this.aUS.sendMessage(requestGetMyPostNetMessage);
    }
}
