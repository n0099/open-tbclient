package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.aq;
/* loaded from: classes9.dex */
public class j {
    protected final FrsModelController gYG;
    protected final com.baidu.tieba.frs.vc.h gYH;
    protected final com.baidu.tieba.frs.n gYq;
    protected final FrsFragment hri;
    protected final com.baidu.tieba.frs.vc.n hsv;
    protected final aq hsw;
    protected final c hsx;

    public j(FrsFragment frsFragment) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.hri = frsFragment;
        this.gYH = this.hri.bOu();
        this.gYq = this.hri.bOx();
        this.hsv = this.hri.bOv();
        this.gYG = this.hri.bOs();
        this.hsw = this.hri.bOw();
        this.hsx = this.hri.bOt();
    }
}
