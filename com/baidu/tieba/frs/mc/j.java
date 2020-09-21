package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ax;
import com.baidu.tieba.frs.q;
/* loaded from: classes21.dex */
public class j {
    protected final q hZV;
    protected final FrsModelController iao;
    protected final com.baidu.tieba.frs.vc.h iap;
    protected final FrsFragment ivI;
    protected final com.baidu.tieba.frs.vc.n iwS;
    protected final ax iwT;
    protected final c iwU;

    public j(FrsFragment frsFragment) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.ivI = frsFragment;
        this.iap = this.ivI.cpc();
        this.hZV = this.ivI.cpf();
        this.iwS = this.ivI.cpd();
        this.iao = this.ivI.cpa();
        this.iwT = this.ivI.cpe();
        this.iwU = this.ivI.cpb();
    }
}
