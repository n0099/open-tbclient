package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.q;
/* loaded from: classes2.dex */
public class j {
    protected final FrsFragment jGE;
    protected final com.baidu.tieba.frs.vc.n jHM;
    protected final at jHN;
    protected final c jHO;
    protected final q jif;
    protected final FrsModelController jix;
    protected final com.baidu.tieba.frs.vc.h jiy;

    public j(FrsFragment frsFragment) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.jGE = frsFragment;
        this.jiy = this.jGE.cCE();
        this.jif = this.jGE.cCH();
        this.jHM = this.jGE.cCF();
        this.jix = this.jGE.cCC();
        this.jHN = this.jGE.cCG();
        this.jHO = this.jGE.cCD();
    }
}
