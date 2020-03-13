package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.al;
import com.baidu.tieba.frs.vc.m;
/* loaded from: classes9.dex */
public class j {
    protected final FrsFragment gGR;
    protected final m gIg;
    protected final al gIh;
    protected final c gIi;
    protected final FrsModelController goP;
    protected final com.baidu.tieba.frs.vc.h goQ;
    protected final com.baidu.tieba.frs.l goz;

    public j(FrsFragment frsFragment) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.gGR = frsFragment;
        this.goQ = this.gGR.bDN();
        this.goz = this.gGR.bDQ();
        this.gIg = this.gGR.bDO();
        this.goP = this.gGR.bDL();
        this.gIh = this.gGR.bDP();
        this.gIi = this.gGR.bDM();
    }
}
