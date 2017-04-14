package com.baidu.tieba.frs.mc;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.frs.RequestGetMyPostNetMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements Runnable {
    final /* synthetic */ l bYk;
    private final /* synthetic */ long bYl;
    private final /* synthetic */ long bYm;
    private final /* synthetic */ long bYn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(l lVar, long j, long j2, long j3) {
        this.bYk = lVar;
        this.bYl = j;
        this.bYm = j2;
        this.bYn = j3;
    }

    @Override // java.lang.Runnable
    public void run() {
        int af = com.baidu.adp.lib.util.k.af(this.bYk.bST.getPageContext().getPageActivity());
        int ag = com.baidu.adp.lib.util.k.ag(this.bYk.bST.getPageContext().getPageActivity());
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        int i = 1;
        if (av.wa().wc()) {
            i = 2;
        }
        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
        requestGetMyPostNetMessage.setParams(this.bYl, this.bYm, this.bYn, af, ag, f, i);
        this.bYk.bST.sendMessage(requestGetMyPostNetMessage);
    }
}
