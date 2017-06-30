package com.baidu.tieba.frs.mc;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements Runnable {
    final /* synthetic */ l cmT;
    private final /* synthetic */ long cmU;
    private final /* synthetic */ long cmV;
    private final /* synthetic */ long cmW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(l lVar, long j, long j2, long j3) {
        this.cmT = lVar;
        this.cmU = j;
        this.cmV = j2;
        this.cmW = j3;
    }

    @Override // java.lang.Runnable
    public void run() {
        int af = com.baidu.adp.lib.util.k.af(TbadkCoreApplication.m9getInst());
        int ag = com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.m9getInst());
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        int i = 1;
        if (ax.vA().vC()) {
            i = 2;
        }
        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
        requestGetMyPostNetMessage.setParams(this.cmU, this.cmV, this.cmW, af, ag, f, i);
        this.cmT.cbE.sendMessage(requestGetMyPostNetMessage);
    }
}
