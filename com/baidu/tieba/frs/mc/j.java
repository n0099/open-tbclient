package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ak;
/* loaded from: classes4.dex */
public class j {
    protected final FrsFragment fHd;
    protected final com.baidu.tieba.frs.vc.k fIm;
    protected final ak fIn;
    protected final c fIo;
    protected final com.baidu.tieba.frs.k foQ;
    protected final FrsModelController fph;
    protected final com.baidu.tieba.frs.vc.f fpi;

    public j(FrsFragment frsFragment) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.fHd = frsFragment;
        this.fpi = this.fHd.bjM();
        this.foQ = this.fHd.bjP();
        this.fIm = this.fHd.bjN();
        this.fph = this.fHd.bjK();
        this.fIn = this.fHd.bjO();
        this.fIo = this.fHd.bjL();
    }
}
