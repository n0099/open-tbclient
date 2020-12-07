package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.aw;
import com.baidu.tieba.frs.q;
/* loaded from: classes22.dex */
public class j {
    protected final q iSV;
    protected final FrsModelController iTn;
    protected final com.baidu.tieba.frs.vc.h iTo;
    protected final FrsFragment jrk;
    protected final com.baidu.tieba.frs.vc.n jsu;
    protected final aw jsv;
    protected final c jsw;

    public j(FrsFragment frsFragment) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.jrk = frsFragment;
        this.iTo = this.jrk.cCb();
        this.iSV = this.jrk.cCe();
        this.jsu = this.jrk.cCc();
        this.iTn = this.jrk.cBZ();
        this.jsv = this.jrk.cCd();
        this.jsw = this.jrk.cCa();
    }
}
