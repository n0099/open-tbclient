package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ak;
/* loaded from: classes4.dex */
public class j {
    protected final FrsFragment fNh;
    protected final com.baidu.tieba.frs.vc.k fOr;
    protected final ak fOs;
    protected final c fOt;
    protected final FrsModelController fuO;
    protected final com.baidu.tieba.frs.vc.f fuP;
    protected final com.baidu.tieba.frs.k fux;

    public j(FrsFragment frsFragment) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.fNh = frsFragment;
        this.fuP = this.fNh.bjK();
        this.fux = this.fNh.bjN();
        this.fOr = this.fNh.bjL();
        this.fuO = this.fNh.bjI();
        this.fOs = this.fNh.bjM();
        this.fOt = this.fNh.bjJ();
    }
}
