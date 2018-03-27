package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.ap;
import com.baidu.tieba.frs.k;
/* loaded from: classes2.dex */
public class h {
    protected final k dEo;
    protected final FrsModelController dEw;
    protected final com.baidu.tieba.frs.g.f dEx;
    protected final com.baidu.tieba.frs.i dSO;
    protected final com.baidu.tieba.frs.g.k dTI;
    protected final ap dTJ;
    protected final c dTK;

    public h(com.baidu.tieba.frs.i iVar) {
        if (iVar == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.dSO = iVar;
        this.dEx = this.dSO.auQ();
        this.dEo = this.dSO.auT();
        this.dTI = this.dSO.auR();
        this.dEw = this.dSO.auO();
        this.dTJ = this.dSO.auS();
        this.dTK = this.dSO.auP();
    }
}
