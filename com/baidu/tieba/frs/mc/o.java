package com.baidu.tieba.frs.mc;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.frs.RequestGetMyPostNetMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements Runnable {
    final /* synthetic */ l ceF;
    private final /* synthetic */ long ceG;
    private final /* synthetic */ long ceH;
    private final /* synthetic */ long ceI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(l lVar, long j, long j2, long j3) {
        this.ceF = lVar;
        this.ceG = j;
        this.ceH = j2;
        this.ceI = j3;
    }

    @Override // java.lang.Runnable
    public void run() {
        int af = com.baidu.adp.lib.util.k.af(TbadkCoreApplication.m9getInst());
        int ag = com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.m9getInst());
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        int i = 1;
        if (av.vl().vn()) {
            i = 2;
        }
        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
        requestGetMyPostNetMessage.setParams(this.ceG, this.ceH, this.ceI, af, ag, f, i);
        this.ceF.bTw.sendMessage(requestGetMyPostNetMessage);
    }
}
