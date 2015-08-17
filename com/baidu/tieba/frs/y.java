package com.baidu.tieba.frs;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class y implements Runnable {
    private final /* synthetic */ long aVn;
    private final /* synthetic */ long aVo;
    private final /* synthetic */ long aVp;
    final /* synthetic */ FrsActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(FrsActivity frsActivity, long j, long j2, long j3) {
        this.this$0 = frsActivity;
        this.aVn = j;
        this.aVo = j2;
        this.aVp = j3;
    }

    @Override // java.lang.Runnable
    public void run() {
        int K = com.baidu.adp.lib.util.k.K(this.this$0.getPageContext().getPageActivity());
        int L = com.baidu.adp.lib.util.k.L(this.this$0.getPageContext().getPageActivity());
        float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
        int i = 1;
        if (com.baidu.tbadk.core.util.ar.uE().uG()) {
            i = 2;
        }
        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
        requestGetMyPostNetMessage.setParams(this.aVn, this.aVo, this.aVp, K, L, f, i);
        this.this$0.sendMessage(requestGetMyPostNetMessage);
    }
}
