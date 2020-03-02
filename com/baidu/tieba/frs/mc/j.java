package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.al;
import com.baidu.tieba.frs.vc.m;
/* loaded from: classes9.dex */
public class j {
    protected final FrsFragment gGF;
    protected final m gHU;
    protected final al gHV;
    protected final c gHW;
    protected final FrsModelController goC;
    protected final com.baidu.tieba.frs.vc.h goD;
    protected final com.baidu.tieba.frs.l gom;

    public j(FrsFragment frsFragment) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.gGF = frsFragment;
        this.goD = this.gGF.bDM();
        this.gom = this.gGF.bDP();
        this.gHU = this.gGF.bDN();
        this.goC = this.gGF.bDK();
        this.gHV = this.gGF.bDO();
        this.gHW = this.gGF.bDL();
    }
}
