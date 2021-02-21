package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.q;
/* loaded from: classes2.dex */
public class j {
    protected final FrsFragment jEV;
    protected final com.baidu.tieba.frs.vc.n jGd;
    protected final at jGe;
    protected final c jGf;
    protected final FrsModelController jgN;
    protected final com.baidu.tieba.frs.vc.h jgO;
    protected final q jgv;

    public j(FrsFragment frsFragment) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.jEV = frsFragment;
        this.jgO = this.jEV.cCy();
        this.jgv = this.jEV.cCB();
        this.jGd = this.jEV.cCz();
        this.jgN = this.jEV.cCw();
        this.jGe = this.jEV.cCA();
        this.jGf = this.jEV.cCx();
    }
}
