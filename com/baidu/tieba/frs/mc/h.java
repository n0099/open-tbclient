package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.k;
/* loaded from: classes6.dex */
public class h {
    protected final k dLB;
    protected final FrsModelController dLL;
    protected final com.baidu.tieba.frs.vc.f dLM;
    protected final FrsFragment edn;
    protected final com.baidu.tieba.frs.vc.k eek;
    protected final an eel;
    protected final c eem;

    public h(FrsFragment frsFragment) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.edn = frsFragment;
        this.dLM = this.edn.aBR();
        this.dLB = this.edn.aBU();
        this.eek = this.edn.aBS();
        this.dLL = this.edn.aBP();
        this.eel = this.edn.aBT();
        this.eem = this.edn.aBQ();
    }
}
