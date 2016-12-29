package com.baidu.tieba.frs.d;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.frs.RequestGetMyPostNetMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Runnable {
    final /* synthetic */ k bMn;
    private final /* synthetic */ long bMo;
    private final /* synthetic */ long bMp;
    private final /* synthetic */ long bMq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(k kVar, long j, long j2, long j3) {
        this.bMn = kVar;
        this.bMo = j;
        this.bMp = j2;
        this.bMq = j3;
    }

    @Override // java.lang.Runnable
    public void run() {
        int I = com.baidu.adp.lib.util.k.I(this.bMn.bFI.getPageContext().getPageActivity());
        int J = com.baidu.adp.lib.util.k.J(this.bMn.bFI.getPageContext().getPageActivity());
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        int i = 1;
        if (aw.vm().vo()) {
            i = 2;
        }
        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
        requestGetMyPostNetMessage.setParams(this.bMo, this.bMp, this.bMq, I, J, f, i);
        this.bMn.bFI.sendMessage(requestGetMyPostNetMessage);
    }
}
