package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.av;
import com.baidu.tieba.frs.p;
/* loaded from: classes9.dex */
public class j {
    protected final FrsModelController hAc;
    protected final com.baidu.tieba.frs.vc.h hAd;
    protected final FrsFragment hUd;
    protected final com.baidu.tieba.frs.vc.n hVo;
    protected final av hVp;
    protected final c hVq;
    protected final p hzK;

    public j(FrsFragment frsFragment) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.hUd = frsFragment;
        this.hAd = this.hUd.bXX();
        this.hzK = this.hUd.bYa();
        this.hVo = this.hUd.bXY();
        this.hAc = this.hUd.bXV();
        this.hVp = this.hUd.bXZ();
        this.hVq = this.hUd.bXW();
    }
}
