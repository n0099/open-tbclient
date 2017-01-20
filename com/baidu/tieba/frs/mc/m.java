package com.baidu.tieba.frs.mc;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.frs.RequestGetMyPostNetMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Runnable {
    final /* synthetic */ j bSA;
    private final /* synthetic */ long bSB;
    private final /* synthetic */ long bSC;
    private final /* synthetic */ long bSD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar, long j, long j2, long j3) {
        this.bSA = jVar;
        this.bSB = j;
        this.bSC = j2;
        this.bSD = j3;
    }

    @Override // java.lang.Runnable
    public void run() {
        int I = com.baidu.adp.lib.util.k.I(this.bSA.bLZ.getPageContext().getPageActivity());
        int J = com.baidu.adp.lib.util.k.J(this.bSA.bLZ.getPageContext().getPageActivity());
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        int i = 1;
        if (au.vg().vi()) {
            i = 2;
        }
        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
        requestGetMyPostNetMessage.setParams(this.bSB, this.bSC, this.bSD, I, J, f, i);
        this.bSA.bLZ.sendMessage(requestGetMyPostNetMessage);
    }
}
