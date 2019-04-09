package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ak;
/* loaded from: classes4.dex */
public class j {
    protected final com.baidu.tieba.frs.k eYF;
    protected final FrsModelController eYW;
    protected final com.baidu.tieba.frs.vc.f eYX;
    protected final FrsFragment fqE;
    protected final com.baidu.tieba.frs.vc.k frO;
    protected final ak frP;
    protected final c frQ;

    public j(FrsFragment frsFragment) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.fqE = frsFragment;
        this.eYX = this.fqE.bcp();
        this.eYF = this.fqE.bcs();
        this.frO = this.fqE.bcq();
        this.eYW = this.fqE.bcn();
        this.frP = this.fqE.bcr();
        this.frQ = this.fqE.bco();
    }
}
