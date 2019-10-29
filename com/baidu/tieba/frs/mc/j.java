package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ak;
/* loaded from: classes4.dex */
public class j {
    protected final FrsFragment fNY;
    protected final com.baidu.tieba.frs.vc.k fPi;
    protected final ak fPj;
    protected final c fPk;
    protected final FrsModelController fvF;
    protected final com.baidu.tieba.frs.vc.f fvG;
    protected final com.baidu.tieba.frs.k fvo;

    public j(FrsFragment frsFragment) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.fNY = frsFragment;
        this.fvG = this.fNY.bjM();
        this.fvo = this.fNY.bjP();
        this.fPi = this.fNY.bjN();
        this.fvF = this.fNY.bjK();
        this.fPj = this.fNY.bjO();
        this.fPk = this.fNY.bjL();
    }
}
