package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ax;
import com.baidu.tieba.frs.q;
/* loaded from: classes21.dex */
public class j {
    protected final q iId;
    protected final FrsModelController iIw;
    protected final com.baidu.tieba.frs.vc.h iIx;
    protected final FrsFragment jdH;
    protected final com.baidu.tieba.frs.vc.n jeR;
    protected final ax jeS;
    protected final c jeT;

    public j(FrsFragment frsFragment) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.jdH = frsFragment;
        this.iIx = this.jdH.cxL();
        this.iId = this.jdH.cxO();
        this.jeR = this.jdH.cxM();
        this.iIw = this.jdH.cxJ();
        this.jeS = this.jdH.cxN();
        this.jeT = this.jdH.cxK();
    }
}
