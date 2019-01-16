package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.k;
/* loaded from: classes6.dex */
public class h {
    protected final k dLA;
    protected final FrsModelController dLK;
    protected final com.baidu.tieba.frs.vc.f dLL;
    protected final FrsFragment edm;
    protected final com.baidu.tieba.frs.vc.k eej;
    protected final an eek;
    protected final c eel;

    public h(FrsFragment frsFragment) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.edm = frsFragment;
        this.dLL = this.edm.aBR();
        this.dLA = this.edm.aBU();
        this.eej = this.edm.aBS();
        this.dLK = this.edm.aBP();
        this.eek = this.edm.aBT();
        this.eel = this.edm.aBQ();
    }
}
