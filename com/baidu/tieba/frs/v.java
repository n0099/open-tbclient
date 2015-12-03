package com.baidu.tieba.frs;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements Runnable {
    final /* synthetic */ FrsActivity bag;
    private final /* synthetic */ long bah;
    private final /* synthetic */ long bai;
    private final /* synthetic */ long baj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(FrsActivity frsActivity, long j, long j2, long j3) {
        this.bag = frsActivity;
        this.bah = j;
        this.bai = j2;
        this.baj = j3;
    }

    @Override // java.lang.Runnable
    public void run() {
        int K = com.baidu.adp.lib.util.k.K(this.bag.getPageContext().getPageActivity());
        int L = com.baidu.adp.lib.util.k.L(this.bag.getPageContext().getPageActivity());
        float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
        int i = 1;
        if (com.baidu.tbadk.core.util.ay.vq().vs()) {
            i = 2;
        }
        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
        requestGetMyPostNetMessage.setParams(this.bah, this.bai, this.baj, K, L, f, i);
        this.bag.sendMessage(requestGetMyPostNetMessage);
    }
}
