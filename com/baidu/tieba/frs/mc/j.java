package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.q;
/* loaded from: classes2.dex */
public class j {
    protected final FrsFragment jDI;
    protected final com.baidu.tieba.frs.vc.n jER;
    protected final at jES;
    protected final c jET;
    protected final FrsModelController jfA;
    protected final com.baidu.tieba.frs.vc.h jfB;
    protected final q jfi;

    public j(FrsFragment frsFragment) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.jDI = frsFragment;
        this.jfB = this.jDI.cEX();
        this.jfi = this.jDI.cFa();
        this.jER = this.jDI.cEY();
        this.jfA = this.jDI.cEV();
        this.jES = this.jDI.cEZ();
        this.jET = this.jDI.cEW();
    }
}
