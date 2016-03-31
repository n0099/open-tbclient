package com.baidu.tieba.frs;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements Runnable {
    final /* synthetic */ FrsActivity blk;
    private final /* synthetic */ long bll;
    private final /* synthetic */ long blm;
    private final /* synthetic */ long bln;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(FrsActivity frsActivity, long j, long j2, long j3) {
        this.blk = frsActivity;
        this.bll = j;
        this.blm = j2;
        this.bln = j3;
    }

    @Override // java.lang.Runnable
    public void run() {
        int B = com.baidu.adp.lib.util.k.B(this.blk.getPageContext().getPageActivity());
        int C = com.baidu.adp.lib.util.k.C(this.blk.getPageContext().getPageActivity());
        float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
        int i = 1;
        if (com.baidu.tbadk.core.util.az.wz().wB()) {
            i = 2;
        }
        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
        requestGetMyPostNetMessage.setParams(this.bll, this.blm, this.bln, B, C, f, i);
        this.blk.sendMessage(requestGetMyPostNetMessage);
    }
}
