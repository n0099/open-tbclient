package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.al;
/* loaded from: classes2.dex */
public class h {
    protected final com.baidu.tieba.frs.i cYo;
    protected final FrsModelController cYw;
    protected final com.baidu.tieba.frs.vc.f cYx;
    protected final FrsFragment dof;
    protected final com.baidu.tieba.frs.vc.j dpb;
    protected final al dpc;
    protected final c dpd;

    public h(FrsFragment frsFragment) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.dof = frsFragment;
        this.cYx = this.dof.apj();
        this.cYo = this.dof.apm();
        this.dpb = this.dof.apk();
        this.cYw = this.dof.apg();
        this.dpc = this.dof.apl();
        this.dpd = this.dof.aph();
    }
}
