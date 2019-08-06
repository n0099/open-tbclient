package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ak;
/* loaded from: classes4.dex */
public class j {
    protected final FrsFragment fMP;
    protected final com.baidu.tieba.frs.vc.k fNY;
    protected final ak fNZ;
    protected final c fOa;
    protected final FrsModelController fuF;
    protected final com.baidu.tieba.frs.vc.f fuG;
    protected final com.baidu.tieba.frs.k fuo;

    public j(FrsFragment frsFragment) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.fMP = frsFragment;
        this.fuG = this.fMP.blV();
        this.fuo = this.fMP.blY();
        this.fNY = this.fMP.blW();
        this.fuF = this.fMP.blT();
        this.fNZ = this.fMP.blX();
        this.fOa = this.fMP.blU();
    }
}
