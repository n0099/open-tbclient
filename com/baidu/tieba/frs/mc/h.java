package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.ap;
import com.baidu.tieba.frs.k;
/* loaded from: classes2.dex */
public class h {
    protected final k dEl;
    protected final FrsModelController dEt;
    protected final com.baidu.tieba.frs.g.f dEu;
    protected final com.baidu.tieba.frs.i dSJ;
    protected final com.baidu.tieba.frs.g.k dTD;
    protected final ap dTE;
    protected final c dTF;

    public h(com.baidu.tieba.frs.i iVar) {
        if (iVar == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.dSJ = iVar;
        this.dEu = this.dSJ.auP();
        this.dEl = this.dSJ.auS();
        this.dTD = this.dSJ.auQ();
        this.dEt = this.dSJ.auN();
        this.dTE = this.dSJ.auR();
        this.dTF = this.dSJ.auO();
    }
}
