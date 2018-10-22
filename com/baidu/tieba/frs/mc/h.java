package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.k;
/* loaded from: classes6.dex */
public class h {
    protected final k dAn;
    protected final FrsModelController dAx;
    protected final com.baidu.tieba.frs.vc.f dAy;
    protected final FrsFragment dSg;
    protected final com.baidu.tieba.frs.vc.j dTd;
    protected final an dTe;
    protected final c dTf;

    public h(FrsFragment frsFragment) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.dSg = frsFragment;
        this.dAy = this.dSg.azy();
        this.dAn = this.dSg.azB();
        this.dTd = this.dSg.azz();
        this.dAx = this.dSg.azw();
        this.dTe = this.dSg.azA();
        this.dTf = this.dSg.azx();
    }
}
