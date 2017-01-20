package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ax;
import com.baidu.tieba.frs.ce;
import com.baidu.tieba.frs.f.ad;
import com.baidu.tieba.frs.f.am;
import com.baidu.tieba.frs.f.u;
/* loaded from: classes.dex */
public class r {
    protected final ax bFF;
    protected final FrsModelController bFQ;
    protected final u bFR;
    protected final am bFS;
    protected final ad bFT;
    protected final com.baidu.tieba.frs.entelechy.b.d bFV;
    protected final FrsActivity bLZ;
    protected final ce bSH;
    protected final h bSI;

    public r(FrsActivity frsActivity) {
        if (frsActivity == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.bLZ = frsActivity;
        this.bFT = this.bLZ.Xz();
        this.bFR = this.bLZ.XC();
        this.bFF = this.bLZ.XF();
        this.bFS = this.bLZ.XA();
        this.bFV = this.bLZ.XD();
        this.bFQ = this.bLZ.Xy();
        this.bSH = this.bLZ.XE();
        this.bSI = this.bLZ.XB();
    }
}
