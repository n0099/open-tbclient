package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ak;
/* loaded from: classes4.dex */
public class j {
    protected final FrsFragment fGZ;
    protected final com.baidu.tieba.frs.vc.k fIj;
    protected final ak fIk;
    protected final c fIl;
    protected final com.baidu.tieba.frs.k foP;
    protected final FrsModelController fpg;
    protected final com.baidu.tieba.frs.vc.f fph;

    public j(FrsFragment frsFragment) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.fGZ = frsFragment;
        this.fph = this.fGZ.bjJ();
        this.foP = this.fGZ.bjM();
        this.fIj = this.fGZ.bjK();
        this.fpg = this.fGZ.bjH();
        this.fIk = this.fGZ.bjL();
        this.fIl = this.fGZ.bjI();
    }
}
