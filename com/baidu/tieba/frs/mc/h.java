package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.k;
/* loaded from: classes6.dex */
public class h {
    protected final k dKR;
    protected final FrsModelController dLb;
    protected final com.baidu.tieba.frs.vc.f dLc;
    protected final FrsFragment ecG;
    protected final com.baidu.tieba.frs.vc.k edD;
    protected final an edE;
    protected final c edF;

    public h(FrsFragment frsFragment) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.ecG = frsFragment;
        this.dLc = this.ecG.aBu();
        this.dKR = this.ecG.aBx();
        this.edD = this.ecG.aBv();
        this.dLb = this.ecG.aBs();
        this.edE = this.ecG.aBw();
        this.edF = this.ecG.aBt();
    }
}
