package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.k;
/* loaded from: classes6.dex */
public class h {
    protected final k dId;
    protected final FrsModelController dIn;
    protected final com.baidu.tieba.frs.vc.f dIo;
    protected final FrsFragment dZP;
    protected final com.baidu.tieba.frs.vc.k eaM;
    protected final an eaN;
    protected final c eaO;

    public h(FrsFragment frsFragment) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.dZP = frsFragment;
        this.dIo = this.dZP.aAF();
        this.dId = this.dZP.aAI();
        this.eaM = this.dZP.aAG();
        this.dIn = this.dZP.aAD();
        this.eaN = this.dZP.aAH();
        this.eaO = this.dZP.aAE();
    }
}
