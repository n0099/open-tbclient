package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.al;
/* loaded from: classes2.dex */
public class h {
    protected final com.baidu.tieba.frs.i dhC;
    protected final FrsModelController dhN;
    protected final com.baidu.tieba.frs.vc.f dhO;
    protected final FrsFragment dxw;
    protected final com.baidu.tieba.frs.vc.j dys;
    protected final al dyt;
    protected final c dyu;

    public h(FrsFragment frsFragment) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.dxw = frsFragment;
        this.dhO = this.dxw.ato();
        this.dhC = this.dxw.atr();
        this.dys = this.dxw.atp();
        this.dhN = this.dxw.atm();
        this.dyt = this.dxw.atq();
        this.dyu = this.dxw.atn();
    }
}
