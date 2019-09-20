package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ak;
/* loaded from: classes4.dex */
public class j {
    protected final FrsFragment fOE;
    protected final com.baidu.tieba.frs.vc.k fPO;
    protected final ak fPP;
    protected final c fPQ;
    protected final com.baidu.tieba.frs.k fwb;
    protected final FrsModelController fws;
    protected final com.baidu.tieba.frs.vc.f fwt;

    public j(FrsFragment frsFragment) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.fOE = frsFragment;
        this.fwt = this.fOE.bmG();
        this.fwb = this.fOE.bmJ();
        this.fPO = this.fOE.bmH();
        this.fws = this.fOE.bmE();
        this.fPP = this.fOE.bmI();
        this.fPQ = this.fOE.bmF();
    }
}
