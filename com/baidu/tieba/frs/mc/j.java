package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.av;
import com.baidu.tieba.frs.p;
/* loaded from: classes16.dex */
public class j {
    protected final FrsModelController hFS;
    protected final com.baidu.tieba.frs.vc.h hFT;
    protected final p hFz;
    protected final FrsFragment iae;
    protected final com.baidu.tieba.frs.vc.n ibp;
    protected final av ibq;
    protected final c ibr;

    public j(FrsFragment frsFragment) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.iae = frsFragment;
        this.hFT = this.iae.cbt();
        this.hFz = this.iae.cbw();
        this.ibp = this.iae.cbu();
        this.hFS = this.iae.cbr();
        this.ibq = this.iae.cbv();
        this.ibr = this.iae.cbs();
    }
}
