package com.baidu.tieba.frs;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements Runnable {
    final /* synthetic */ FrsActivity bEL;
    private final /* synthetic */ long bEQ;
    private final /* synthetic */ long bER;
    private final /* synthetic */ long bES;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(FrsActivity frsActivity, long j, long j2, long j3) {
        this.bEL = frsActivity;
        this.bEQ = j;
        this.bER = j2;
        this.bES = j3;
    }

    @Override // java.lang.Runnable
    public void run() {
        int A = com.baidu.adp.lib.util.k.A(this.bEL.getPageContext().getPageActivity());
        int B = com.baidu.adp.lib.util.k.B(this.bEL.getPageContext().getPageActivity());
        float f = TbadkCoreApplication.m10getInst().getApp().getResources().getDisplayMetrics().density;
        int i = 1;
        if (com.baidu.tbadk.core.util.bb.ue().ug()) {
            i = 2;
        }
        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
        requestGetMyPostNetMessage.setParams(this.bEQ, this.bER, this.bES, A, B, f, i);
        this.bEL.sendMessage(requestGetMyPostNetMessage);
    }
}
