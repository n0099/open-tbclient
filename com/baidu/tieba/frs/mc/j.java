package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ak;
/* loaded from: classes4.dex */
public class j {
    protected final com.baidu.tieba.frs.k eYE;
    protected final FrsModelController eYV;
    protected final com.baidu.tieba.frs.vc.f eYW;
    protected final FrsFragment fqE;
    protected final com.baidu.tieba.frs.vc.k frO;
    protected final ak frP;
    protected final c frQ;

    public j(FrsFragment frsFragment) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.fqE = frsFragment;
        this.eYW = this.fqE.bcp();
        this.eYE = this.fqE.bcs();
        this.frO = this.fqE.bcq();
        this.eYV = this.fqE.bcn();
        this.frP = this.fqE.bcr();
        this.frQ = this.fqE.bco();
    }
}
