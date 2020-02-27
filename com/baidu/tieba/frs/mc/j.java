package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.al;
import com.baidu.tieba.frs.vc.m;
/* loaded from: classes9.dex */
public class j {
    protected final FrsFragment gGD;
    protected final m gHS;
    protected final al gHT;
    protected final c gHU;
    protected final FrsModelController goA;
    protected final com.baidu.tieba.frs.vc.h goB;
    protected final com.baidu.tieba.frs.l gok;

    public j(FrsFragment frsFragment) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.gGD = frsFragment;
        this.goB = this.gGD.bDK();
        this.gok = this.gGD.bDN();
        this.gHS = this.gGD.bDL();
        this.goA = this.gGD.bDI();
        this.gHT = this.gGD.bDM();
        this.gHU = this.gGD.bDJ();
    }
}
