package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.k;
/* loaded from: classes6.dex */
public class h {
    protected final k dBE;
    protected final FrsModelController dBO;
    protected final com.baidu.tieba.frs.vc.f dBP;
    protected final FrsFragment dTm;
    protected final com.baidu.tieba.frs.vc.k dUj;
    protected final an dUk;
    protected final c dUl;

    public h(FrsFragment frsFragment) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.dTm = frsFragment;
        this.dBP = this.dTm.ayV();
        this.dBE = this.dTm.ayY();
        this.dUj = this.dTm.ayW();
        this.dBO = this.dTm.ayT();
        this.dUk = this.dTm.ayX();
        this.dUl = this.dTm.ayU();
    }
}
