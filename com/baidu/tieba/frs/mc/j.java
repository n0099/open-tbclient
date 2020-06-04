package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.aq;
/* loaded from: classes9.dex */
public class j {
    protected final FrsFragment hGQ;
    protected final com.baidu.tieba.frs.vc.n hIc;
    protected final aq hId;
    protected final c hIe;
    protected final FrsModelController hnJ;
    protected final com.baidu.tieba.frs.vc.h hnK;
    protected final com.baidu.tieba.frs.n hnt;

    public j(FrsFragment frsFragment) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.hGQ = frsFragment;
        this.hnK = this.hGQ.bUQ();
        this.hnt = this.hGQ.bUT();
        this.hIc = this.hGQ.bUR();
        this.hnJ = this.hGQ.bUO();
        this.hId = this.hGQ.bUS();
        this.hIe = this.hGQ.bUP();
    }
}
