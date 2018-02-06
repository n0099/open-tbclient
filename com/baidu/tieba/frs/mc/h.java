package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.ap;
import com.baidu.tieba.frs.k;
/* loaded from: classes2.dex */
public class h {
    protected final FrsModelController dEF;
    protected final com.baidu.tieba.frs.g.f dEG;
    protected final k dEx;
    protected final com.baidu.tieba.frs.i dSV;
    protected final com.baidu.tieba.frs.g.k dTP;
    protected final ap dTQ;
    protected final c dTR;

    public h(com.baidu.tieba.frs.i iVar) {
        if (iVar == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.dSV = iVar;
        this.dEG = this.dSV.auQ();
        this.dEx = this.dSV.auT();
        this.dTP = this.dSV.auR();
        this.dEF = this.dSV.auO();
        this.dTQ = this.dSV.auS();
        this.dTR = this.dSV.auP();
    }
}
