package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.k;
/* loaded from: classes6.dex */
public class h {
    protected final k dAn;
    protected final FrsModelController dAx;
    protected final com.baidu.tieba.frs.vc.f dAy;
    protected final FrsFragment dSf;
    protected final com.baidu.tieba.frs.vc.j dTc;
    protected final an dTd;
    protected final c dTe;

    public h(FrsFragment frsFragment) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.dSf = frsFragment;
        this.dAy = this.dSf.azx();
        this.dAn = this.dSf.azA();
        this.dTc = this.dSf.azy();
        this.dAx = this.dSf.azv();
        this.dTd = this.dSf.azz();
        this.dTe = this.dSf.azw();
    }
}
