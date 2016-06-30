package com.baidu.tieba.frs;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements Runnable {
    final /* synthetic */ FrsActivity bDB;
    private final /* synthetic */ long bDG;
    private final /* synthetic */ long bDH;
    private final /* synthetic */ long bDI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(FrsActivity frsActivity, long j, long j2, long j3) {
        this.bDB = frsActivity;
        this.bDG = j;
        this.bDH = j2;
        this.bDI = j3;
    }

    @Override // java.lang.Runnable
    public void run() {
        int A = com.baidu.adp.lib.util.k.A(this.bDB.getPageContext().getPageActivity());
        int B = com.baidu.adp.lib.util.k.B(this.bDB.getPageContext().getPageActivity());
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        int i = 1;
        if (com.baidu.tbadk.core.util.bb.uf().uh()) {
            i = 2;
        }
        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
        requestGetMyPostNetMessage.setParams(this.bDG, this.bDH, this.bDI, A, B, f, i);
        this.bDB.sendMessage(requestGetMyPostNetMessage);
    }
}
