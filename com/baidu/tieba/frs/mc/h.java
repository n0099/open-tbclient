package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.al;
/* loaded from: classes2.dex */
public class h {
    protected final com.baidu.tieba.frs.i cXh;
    protected final FrsModelController cXp;
    protected final com.baidu.tieba.frs.vc.f cXq;
    protected final FrsFragment dmW;
    protected final com.baidu.tieba.frs.vc.j dnT;
    protected final al dnU;
    protected final c dnV;

    public h(FrsFragment frsFragment) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.dmW = frsFragment;
        this.cXq = this.dmW.apk();
        this.cXh = this.dmW.apn();
        this.dnT = this.dmW.apl();
        this.cXp = this.dmW.aph();
        this.dnU = this.dmW.apm();
        this.dnV = this.dmW.apj();
    }
}
