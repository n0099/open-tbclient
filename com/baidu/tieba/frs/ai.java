package com.baidu.tieba.frs;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements Runnable {
    final /* synthetic */ FrsActivity bQi;
    private final /* synthetic */ long bQo;
    private final /* synthetic */ long bQp;
    private final /* synthetic */ long bQq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(FrsActivity frsActivity, long j, long j2, long j3) {
        this.bQi = frsActivity;
        this.bQo = j;
        this.bQp = j2;
        this.bQq = j3;
    }

    @Override // java.lang.Runnable
    public void run() {
        int K = com.baidu.adp.lib.util.k.K(this.bQi.getPageContext().getPageActivity());
        int L = com.baidu.adp.lib.util.k.L(this.bQi.getPageContext().getPageActivity());
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        int i = 1;
        if (com.baidu.tbadk.core.util.ba.vy().vA()) {
            i = 2;
        }
        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
        requestGetMyPostNetMessage.setParams(this.bQo, this.bQp, this.bQq, K, L, f, i);
        this.bQi.sendMessage(requestGetMyPostNetMessage);
    }
}
