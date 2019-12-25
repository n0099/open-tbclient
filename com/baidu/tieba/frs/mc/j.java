package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.al;
import com.baidu.tieba.frs.vc.m;
/* loaded from: classes6.dex */
public class j {
    protected final FrsFragment gBu;
    protected final m gCE;
    protected final al gCF;
    protected final c gCG;
    protected final com.baidu.tieba.frs.l gja;
    protected final FrsModelController gjp;
    protected final com.baidu.tieba.frs.vc.h gjq;

    public j(FrsFragment frsFragment) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.gBu = frsFragment;
        this.gjq = this.gBu.bBf();
        this.gja = this.gBu.bBi();
        this.gCE = this.gBu.bBg();
        this.gjp = this.gBu.bBd();
        this.gCF = this.gBu.bBh();
        this.gCG = this.gBu.bBe();
    }
}
