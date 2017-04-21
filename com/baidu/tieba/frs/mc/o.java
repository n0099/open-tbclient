package com.baidu.tieba.frs.mc;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.frs.RequestGetMyPostNetMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements Runnable {
    final /* synthetic */ l caB;
    private final /* synthetic */ long caC;
    private final /* synthetic */ long caD;
    private final /* synthetic */ long caE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(l lVar, long j, long j2, long j3) {
        this.caB = lVar;
        this.caC = j;
        this.caD = j2;
        this.caE = j3;
    }

    @Override // java.lang.Runnable
    public void run() {
        int af = com.baidu.adp.lib.util.k.af(this.caB.bVk.getPageContext().getPageActivity());
        int ag = com.baidu.adp.lib.util.k.ag(this.caB.bVk.getPageContext().getPageActivity());
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        int i = 1;
        if (av.wa().wc()) {
            i = 2;
        }
        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
        requestGetMyPostNetMessage.setParams(this.caC, this.caD, this.caE, af, ag, f, i);
        this.caB.bVk.sendMessage(requestGetMyPostNetMessage);
    }
}
