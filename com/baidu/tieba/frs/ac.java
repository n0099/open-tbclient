package com.baidu.tieba.frs;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements Runnable {
    final /* synthetic */ FrsActivity bhl;
    private final /* synthetic */ long bhp;
    private final /* synthetic */ long bhq;
    private final /* synthetic */ long bhr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(FrsActivity frsActivity, long j, long j2, long j3) {
        this.bhl = frsActivity;
        this.bhp = j;
        this.bhq = j2;
        this.bhr = j3;
    }

    @Override // java.lang.Runnable
    public void run() {
        int B = com.baidu.adp.lib.util.k.B(this.bhl.getPageContext().getPageActivity());
        int C = com.baidu.adp.lib.util.k.C(this.bhl.getPageContext().getPageActivity());
        float f = TbadkCoreApplication.m11getInst().getApp().getResources().getDisplayMetrics().density;
        int i = 1;
        if (com.baidu.tbadk.core.util.az.uf().uh()) {
            i = 2;
        }
        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
        requestGetMyPostNetMessage.setParams(this.bhp, this.bhq, this.bhr, B, C, f, i);
        this.bhl.sendMessage(requestGetMyPostNetMessage);
    }
}
