package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ax;
import com.baidu.tieba.frs.q;
/* loaded from: classes22.dex */
public class j {
    protected final FrsFragment iKB;
    protected final com.baidu.tieba.frs.vc.n iLL;
    protected final ax iLM;
    protected final c iLN;
    protected final q ioW;
    protected final FrsModelController ipp;
    protected final com.baidu.tieba.frs.vc.h ipq;

    public j(FrsFragment frsFragment) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.iKB = frsFragment;
        this.ipq = this.iKB.csA();
        this.ioW = this.iKB.csD();
        this.iLL = this.iKB.csB();
        this.ipp = this.iKB.csy();
        this.iLM = this.iKB.csC();
        this.iLN = this.iKB.csz();
    }
}
