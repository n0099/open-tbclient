package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ax;
import com.baidu.tieba.frs.ce;
import com.baidu.tieba.frs.f.ad;
import com.baidu.tieba.frs.f.ao;
/* loaded from: classes.dex */
public class u {
    protected final ax bMN;
    protected final FrsModelController bMY;
    protected final com.baidu.tieba.frs.f.u bMZ;
    protected final ao bNa;
    protected final ad bNb;
    protected final com.baidu.tieba.frs.entelechy.b.d bNd;
    protected final FrsActivity bTf;
    protected final ce bZT;
    protected final h bZU;

    public u(FrsActivity frsActivity) {
        if (frsActivity == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.bTf = frsActivity;
        this.bNb = this.bTf.Yy();
        this.bMZ = this.bTf.YB();
        this.bMN = this.bTf.YE();
        this.bNa = this.bTf.Yz();
        this.bNd = this.bTf.YC();
        this.bMY = this.bTf.Yx();
        this.bZT = this.bTf.YD();
        this.bZU = this.bTf.YA();
    }
}
