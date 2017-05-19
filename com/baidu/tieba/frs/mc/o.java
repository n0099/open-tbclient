package com.baidu.tieba.frs.mc;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.frs.RequestGetMyPostNetMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements Runnable {
    final /* synthetic */ l bYt;
    private final /* synthetic */ long bYu;
    private final /* synthetic */ long bYv;
    private final /* synthetic */ long bYw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(l lVar, long j, long j2, long j3) {
        this.bYt = lVar;
        this.bYu = j;
        this.bYv = j2;
        this.bYw = j3;
    }

    @Override // java.lang.Runnable
    public void run() {
        int af = com.baidu.adp.lib.util.k.af(TbadkCoreApplication.m9getInst());
        int ag = com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.m9getInst());
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        int i = 1;
        if (av.vo().vq()) {
            i = 2;
        }
        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
        requestGetMyPostNetMessage.setParams(this.bYu, this.bYv, this.bYw, af, ag, f, i);
        this.bYt.bNK.sendMessage(requestGetMyPostNetMessage);
    }
}
