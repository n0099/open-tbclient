package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ax;
import com.baidu.tieba.frs.q;
/* loaded from: classes16.dex */
public class j {
    protected final q hSP;
    protected final FrsModelController hTi;
    protected final com.baidu.tieba.frs.vc.h hTj;
    protected final FrsFragment iom;
    protected final com.baidu.tieba.frs.vc.n ipw;
    protected final ax ipx;
    protected final c ipy;

    public j(FrsFragment frsFragment) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.iom = frsFragment;
        this.hTj = this.iom.clP();
        this.hSP = this.iom.clS();
        this.ipw = this.iom.clQ();
        this.hTi = this.iom.clN();
        this.ipx = this.iom.clR();
        this.ipy = this.iom.clO();
    }
}
