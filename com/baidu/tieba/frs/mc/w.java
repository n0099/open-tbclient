package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.az;
import com.baidu.tieba.frs.cg;
import com.baidu.tieba.frs.g.ad;
import com.baidu.tieba.frs.g.ao;
/* loaded from: classes.dex */
public class w {
    protected final az bMD;
    protected final FrsModelController bMO;
    protected final com.baidu.tieba.frs.g.u bMP;
    protected final ao bMQ;
    protected final ad bMR;
    protected final com.baidu.tieba.frs.entelechy.b.d bMT;
    protected final FrsActivity bST;
    protected final cg bYu;
    protected final h bYv;

    public w(FrsActivity frsActivity) {
        if (frsActivity == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.bST = frsActivity;
        this.bMR = this.bST.YU();
        this.bMP = this.bST.YX();
        this.bMD = this.bST.Za();
        this.bMQ = this.bST.YV();
        this.bMT = this.bST.YY();
        this.bMO = this.bST.YT();
        this.bYu = this.bST.YZ();
        this.bYv = this.bST.YW();
    }
}
