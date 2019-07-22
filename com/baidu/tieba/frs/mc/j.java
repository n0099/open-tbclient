package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ak;
/* loaded from: classes4.dex */
public class j {
    protected final FrsFragment fMb;
    protected final com.baidu.tieba.frs.vc.k fNk;
    protected final ak fNl;
    protected final c fNm;
    protected final com.baidu.tieba.frs.k ftP;
    protected final FrsModelController fug;
    protected final com.baidu.tieba.frs.vc.f fuh;

    public j(FrsFragment frsFragment) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.fMb = frsFragment;
        this.fuh = this.fMb.blO();
        this.ftP = this.fMb.blR();
        this.fNk = this.fMb.blP();
        this.fug = this.fMb.blM();
        this.fNl = this.fMb.blQ();
        this.fNm = this.fMb.blN();
    }
}
