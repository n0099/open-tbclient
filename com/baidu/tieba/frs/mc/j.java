package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ak;
/* loaded from: classes4.dex */
public class j {
    protected final FrsFragment fHa;
    protected final com.baidu.tieba.frs.vc.k fIk;
    protected final ak fIl;
    protected final c fIm;
    protected final com.baidu.tieba.frs.k foQ;
    protected final FrsModelController fph;
    protected final com.baidu.tieba.frs.vc.f fpi;

    public j(FrsFragment frsFragment) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.fHa = frsFragment;
        this.fpi = this.fHa.bjM();
        this.foQ = this.fHa.bjP();
        this.fIk = this.fHa.bjN();
        this.fph = this.fHa.bjK();
        this.fIl = this.fHa.bjO();
        this.fIm = this.fHa.bjL();
    }
}
