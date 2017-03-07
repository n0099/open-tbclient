package com.baidu.tieba.frs.mc;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.frs.RequestGetMyPostNetMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Runnable {
    final /* synthetic */ k bZK;
    private final /* synthetic */ long bZL;
    private final /* synthetic */ long bZM;
    private final /* synthetic */ long bZN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(k kVar, long j, long j2, long j3) {
        this.bZK = kVar;
        this.bZL = j;
        this.bZM = j2;
        this.bZN = j3;
    }

    @Override // java.lang.Runnable
    public void run() {
        int ag = com.baidu.adp.lib.util.k.ag(this.bZK.bTf.getPageContext().getPageActivity());
        int ah = com.baidu.adp.lib.util.k.ah(this.bZK.bTf.getPageContext().getPageActivity());
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        int i = 1;
        if (av.vD().vF()) {
            i = 2;
        }
        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
        requestGetMyPostNetMessage.setParams(this.bZL, this.bZM, this.bZN, ag, ah, f, i);
        this.bZK.bTf.sendMessage(requestGetMyPostNetMessage);
    }
}
