package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.al;
import com.baidu.tieba.frs.vc.m;
/* loaded from: classes7.dex */
public class j {
    protected final FrsFragment gEE;
    protected final m gFT;
    protected final al gFU;
    protected final c gFV;
    protected final com.baidu.tieba.frs.vc.h gmA;
    protected final com.baidu.tieba.frs.l gmj;
    protected final FrsModelController gmz;

    public j(FrsFragment frsFragment) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.gEE = frsFragment;
        this.gmA = this.gEE.bCh();
        this.gmj = this.gEE.bCk();
        this.gFT = this.gEE.bCi();
        this.gmz = this.gEE.bCf();
        this.gFU = this.gEE.bCj();
        this.gFV = this.gEE.bCg();
    }
}
