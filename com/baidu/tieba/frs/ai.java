package com.baidu.tieba.frs;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements Runnable {
    final /* synthetic */ FrsActivity bQp;
    private final /* synthetic */ long bQv;
    private final /* synthetic */ long bQw;
    private final /* synthetic */ long bQx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(FrsActivity frsActivity, long j, long j2, long j3) {
        this.bQp = frsActivity;
        this.bQv = j;
        this.bQw = j2;
        this.bQx = j3;
    }

    @Override // java.lang.Runnable
    public void run() {
        int K = com.baidu.adp.lib.util.k.K(this.bQp.getPageContext().getPageActivity());
        int L = com.baidu.adp.lib.util.k.L(this.bQp.getPageContext().getPageActivity());
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        int i = 1;
        if (com.baidu.tbadk.core.util.bb.vk().vm()) {
            i = 2;
        }
        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
        requestGetMyPostNetMessage.setParams(this.bQv, this.bQw, this.bQx, K, L, f, i);
        this.bQp.sendMessage(requestGetMyPostNetMessage);
    }
}
