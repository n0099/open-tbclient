package com.baidu.tieba.frs;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class y implements Runnable {
    final /* synthetic */ FrsActivity aUK;
    private final /* synthetic */ long aUN;
    private final /* synthetic */ long aUO;
    private final /* synthetic */ long aUP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(FrsActivity frsActivity, long j, long j2, long j3) {
        this.aUK = frsActivity;
        this.aUN = j;
        this.aUO = j2;
        this.aUP = j3;
    }

    @Override // java.lang.Runnable
    public void run() {
        int K = com.baidu.adp.lib.util.k.K(this.aUK.getPageContext().getPageActivity());
        int L = com.baidu.adp.lib.util.k.L(this.aUK.getPageContext().getPageActivity());
        float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
        int i = 1;
        if (com.baidu.tbadk.core.util.at.uJ().uL()) {
            i = 2;
        }
        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
        requestGetMyPostNetMessage.setParams(this.aUN, this.aUO, this.aUP, K, L, f, i);
        this.aUK.sendMessage(requestGetMyPostNetMessage);
    }
}
