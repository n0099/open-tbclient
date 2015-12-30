package com.baidu.tieba.frs;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements Runnable {
    final /* synthetic */ FrsActivity bed;
    private final /* synthetic */ long bee;
    private final /* synthetic */ long bef;
    private final /* synthetic */ long beg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(FrsActivity frsActivity, long j, long j2, long j3) {
        this.bed = frsActivity;
        this.bee = j;
        this.bef = j2;
        this.beg = j3;
    }

    @Override // java.lang.Runnable
    public void run() {
        int K = com.baidu.adp.lib.util.k.K(this.bed.getPageContext().getPageActivity());
        int L = com.baidu.adp.lib.util.k.L(this.bed.getPageContext().getPageActivity());
        float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
        int i = 1;
        if (com.baidu.tbadk.core.util.ay.va().vc()) {
            i = 2;
        }
        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
        requestGetMyPostNetMessage.setParams(this.bee, this.bef, this.beg, K, L, f, i);
        this.bed.sendMessage(requestGetMyPostNetMessage);
    }
}
