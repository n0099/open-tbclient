package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ax;
import com.baidu.tieba.frs.q;
/* loaded from: classes16.dex */
public class j {
    protected final q hSV;
    protected final FrsModelController hTo;
    protected final com.baidu.tieba.frs.vc.h hTp;
    protected final FrsFragment ios;
    protected final com.baidu.tieba.frs.vc.n ipC;
    protected final ax ipD;
    protected final c ipE;

    public j(FrsFragment frsFragment) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.ios = frsFragment;
        this.hTp = this.ios.clQ();
        this.hSV = this.ios.clT();
        this.ipC = this.ios.clR();
        this.hTo = this.ios.clO();
        this.ipD = this.ios.clS();
        this.ipE = this.ios.clP();
    }
}
