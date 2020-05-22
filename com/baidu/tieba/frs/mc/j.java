package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.aq;
/* loaded from: classes9.dex */
public class j {
    protected final FrsFragment hGd;
    protected final com.baidu.tieba.frs.vc.n hHp;
    protected final aq hHq;
    protected final c hHr;
    protected final com.baidu.tieba.frs.n hni;
    protected final FrsModelController hny;
    protected final com.baidu.tieba.frs.vc.h hnz;

    public j(FrsFragment frsFragment) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.hGd = frsFragment;
        this.hnz = this.hGd.bUO();
        this.hni = this.hGd.bUR();
        this.hHp = this.hGd.bUP();
        this.hny = this.hGd.bUM();
        this.hHq = this.hGd.bUQ();
        this.hHr = this.hGd.bUN();
    }
}
