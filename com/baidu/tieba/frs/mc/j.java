package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.q;
/* loaded from: classes2.dex */
public class j {
    protected final com.baidu.tieba.frs.vc.n jAl;
    protected final at jAm;
    protected final c jAn;
    protected final q jaB;
    protected final FrsModelController jaT;
    protected final com.baidu.tieba.frs.vc.h jaU;
    protected final FrsFragment jzc;

    public j(FrsFragment frsFragment) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.jzc = frsFragment;
        this.jaU = this.jzc.cBf();
        this.jaB = this.jzc.cBi();
        this.jAl = this.jzc.cBg();
        this.jaT = this.jzc.cBd();
        this.jAm = this.jzc.cBh();
        this.jAn = this.jzc.cBe();
    }
}
