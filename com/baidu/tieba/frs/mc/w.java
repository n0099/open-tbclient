package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.az;
import com.baidu.tieba.frs.cg;
import com.baidu.tieba.frs.g.ad;
import com.baidu.tieba.frs.g.ao;
/* loaded from: classes.dex */
public class w {
    protected final az bOU;
    protected final FrsModelController bPf;
    protected final com.baidu.tieba.frs.g.u bPg;
    protected final ao bPh;
    protected final ad bPi;
    protected final com.baidu.tieba.frs.entelechy.b.d bPk;
    protected final FrsActivity bVk;
    protected final cg caL;
    protected final h caM;

    public w(FrsActivity frsActivity) {
        if (frsActivity == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.bVk = frsActivity;
        this.bPi = this.bVk.ZV();
        this.bPg = this.bVk.ZY();
        this.bOU = this.bVk.aab();
        this.bPh = this.bVk.ZW();
        this.bPk = this.bVk.ZZ();
        this.bPf = this.bVk.ZU();
        this.caL = this.bVk.aaa();
        this.caM = this.bVk.ZX();
    }
}
