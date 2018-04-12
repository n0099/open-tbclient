package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.al;
/* loaded from: classes2.dex */
public class h {
    protected final com.baidu.tieba.frs.i cXk;
    protected final FrsModelController cXs;
    protected final com.baidu.tieba.frs.vc.f cXt;
    protected final FrsFragment dmZ;
    protected final com.baidu.tieba.frs.vc.j dnW;
    protected final al dnX;
    protected final c dnY;

    public h(FrsFragment frsFragment) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.dmZ = frsFragment;
        this.cXt = this.dmZ.apk();
        this.cXk = this.dmZ.apn();
        this.dnW = this.dmZ.apl();
        this.cXs = this.dmZ.aph();
        this.dnX = this.dmZ.apm();
        this.dnY = this.dmZ.apj();
    }
}
