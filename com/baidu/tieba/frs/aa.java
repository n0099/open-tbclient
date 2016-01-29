package com.baidu.tieba.frs;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements Runnable {
    private final /* synthetic */ long bgA;
    private final /* synthetic */ long bgB;
    private final /* synthetic */ long bgC;
    final /* synthetic */ FrsActivity bgz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(FrsActivity frsActivity, long j, long j2, long j3) {
        this.bgz = frsActivity;
        this.bgA = j;
        this.bgB = j2;
        this.bgC = j3;
    }

    @Override // java.lang.Runnable
    public void run() {
        int K = com.baidu.adp.lib.util.k.K(this.bgz.getPageContext().getPageActivity());
        int L = com.baidu.adp.lib.util.k.L(this.bgz.getPageContext().getPageActivity());
        float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
        int i = 1;
        if (com.baidu.tbadk.core.util.ax.wg().wi()) {
            i = 2;
        }
        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
        requestGetMyPostNetMessage.setParams(this.bgA, this.bgB, this.bgC, K, L, f, i);
        this.bgz.sendMessage(requestGetMyPostNetMessage);
    }
}
