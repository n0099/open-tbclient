package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.k;
/* loaded from: classes2.dex */
public class h {
    protected final FrsFragment dDt;
    protected final com.baidu.tieba.frs.vc.j dEq;
    protected final an dEr;
    protected final c dEs;
    protected final com.baidu.tieba.frs.vc.f dmA;
    protected final k dmo;
    protected final FrsModelController dmz;

    public h(FrsFragment frsFragment) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.dDt = frsFragment;
        this.dmA = this.dDt.aui();
        this.dmo = this.dDt.aul();
        this.dEq = this.dDt.auj();
        this.dmz = this.dDt.aug();
        this.dEr = this.dDt.auk();
        this.dEs = this.dDt.auh();
    }
}
