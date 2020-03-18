package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.am;
/* loaded from: classes9.dex */
public class j {
    protected final FrsFragment gHP;
    protected final com.baidu.tieba.frs.vc.m gJf;
    protected final am gJg;
    protected final c gJh;
    protected final com.baidu.tieba.frs.vc.h gpA;
    protected final com.baidu.tieba.frs.m gpj;
    protected final FrsModelController gpz;

    public j(FrsFragment frsFragment) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.gHP = frsFragment;
        this.gpA = this.gHP.bDV();
        this.gpj = this.gHP.bDY();
        this.gJf = this.gHP.bDW();
        this.gpz = this.gHP.bDT();
        this.gJg = this.gHP.bDX();
        this.gJh = this.gHP.bDU();
    }
}
