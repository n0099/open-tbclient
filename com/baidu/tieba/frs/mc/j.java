package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.aw;
import com.baidu.tieba.frs.q;
/* loaded from: classes22.dex */
public class j {
    protected final q iSX;
    protected final FrsModelController iTp;
    protected final com.baidu.tieba.frs.vc.h iTq;
    protected final FrsFragment jrm;
    protected final com.baidu.tieba.frs.vc.n jsw;
    protected final aw jsx;
    protected final c jsy;

    public j(FrsFragment frsFragment) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.jrm = frsFragment;
        this.iTq = this.jrm.cCc();
        this.iSX = this.jrm.cCf();
        this.jsw = this.jrm.cCd();
        this.iTp = this.jrm.cCa();
        this.jsx = this.jrm.cCe();
        this.jsy = this.jrm.cCb();
    }
}
