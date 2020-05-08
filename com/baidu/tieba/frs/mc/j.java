package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.aq;
/* loaded from: classes9.dex */
public class j {
    protected final FrsModelController gYM;
    protected final com.baidu.tieba.frs.vc.h gYN;
    protected final com.baidu.tieba.frs.n gYw;
    protected final FrsFragment hro;
    protected final com.baidu.tieba.frs.vc.n hsB;
    protected final aq hsC;
    protected final c hsD;

    public j(FrsFragment frsFragment) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.hro = frsFragment;
        this.gYN = this.hro.bOs();
        this.gYw = this.hro.bOv();
        this.hsB = this.hro.bOt();
        this.gYM = this.hro.bOq();
        this.hsC = this.hro.bOu();
        this.hsD = this.hro.bOr();
    }
}
