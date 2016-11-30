package com.baidu.tieba.frs.e;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.frs.RequestGetMyPostNetMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Runnable {
    final /* synthetic */ k cgE;
    private final /* synthetic */ long cgF;
    private final /* synthetic */ long cgG;
    private final /* synthetic */ long cgH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(k kVar, long j, long j2, long j3) {
        this.cgE = kVar;
        this.cgF = j;
        this.cgG = j2;
        this.cgH = j3;
    }

    @Override // java.lang.Runnable
    public void run() {
        int K = com.baidu.adp.lib.util.k.K(this.cgE.bZY.getPageContext().getPageActivity());
        int L = com.baidu.adp.lib.util.k.L(this.cgE.bZY.getPageContext().getPageActivity());
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        int i = 1;
        if (ay.vC().vE()) {
            i = 2;
        }
        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
        requestGetMyPostNetMessage.setParams(this.cgF, this.cgG, this.cgH, K, L, f, i);
        this.cgE.bZY.sendMessage(requestGetMyPostNetMessage);
    }
}
