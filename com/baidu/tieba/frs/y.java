package com.baidu.tieba.frs;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class y implements Runnable {
    private final /* synthetic */ long aUC;
    private final /* synthetic */ long aUD;
    private final /* synthetic */ long aUE;
    final /* synthetic */ FrsActivity aUz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(FrsActivity frsActivity, long j, long j2, long j3) {
        this.aUz = frsActivity;
        this.aUC = j;
        this.aUD = j2;
        this.aUE = j3;
    }

    @Override // java.lang.Runnable
    public void run() {
        int K = com.baidu.adp.lib.util.k.K(this.aUz.getPageContext().getPageActivity());
        int L = com.baidu.adp.lib.util.k.L(this.aUz.getPageContext().getPageActivity());
        float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
        int i = 1;
        if (com.baidu.tbadk.core.util.as.uI().uK()) {
            i = 2;
        }
        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
        requestGetMyPostNetMessage.setParams(this.aUC, this.aUD, this.aUE, K, L, f, i);
        this.aUz.sendMessage(requestGetMyPostNetMessage);
    }
}
