package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.k;
/* loaded from: classes2.dex */
public class h {
    protected final FrsFragment dDw;
    protected final com.baidu.tieba.frs.vc.j dEt;
    protected final an dEu;
    protected final c dEv;
    protected final FrsModelController dmB;
    protected final com.baidu.tieba.frs.vc.f dmC;
    protected final k dmq;

    public h(FrsFragment frsFragment) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.dDw = frsFragment;
        this.dmC = this.dDw.auj();
        this.dmq = this.dDw.aum();
        this.dEt = this.dDw.auk();
        this.dmB = this.dDw.auh();
        this.dEu = this.dDw.aul();
        this.dEv = this.dDw.aui();
    }
}
