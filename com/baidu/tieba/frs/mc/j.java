package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.q;
/* loaded from: classes2.dex */
public class j {
    protected final FrsFragment jEH;
    protected final com.baidu.tieba.frs.vc.n jFP;
    protected final at jFQ;
    protected final c jFR;
    protected final com.baidu.tieba.frs.vc.h jgA;
    protected final q jgh;
    protected final FrsModelController jgz;

    public j(FrsFragment frsFragment) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.jEH = frsFragment;
        this.jgA = this.jEH.cCr();
        this.jgh = this.jEH.cCu();
        this.jFP = this.jEH.cCs();
        this.jgz = this.jEH.cCp();
        this.jFQ = this.jEH.cCt();
        this.jFR = this.jEH.cCq();
    }
}
