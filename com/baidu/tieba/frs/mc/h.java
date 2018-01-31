package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.ap;
import com.baidu.tieba.frs.k;
/* loaded from: classes2.dex */
public class h {
    protected final k dBD;
    protected final FrsModelController dBL;
    protected final com.baidu.tieba.frs.f.f dBM;
    protected final com.baidu.tieba.frs.i dPK;
    protected final com.baidu.tieba.frs.f.k dQE;
    protected final ap dQF;
    protected final c dQG;

    public h(com.baidu.tieba.frs.i iVar) {
        if (iVar == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.dPK = iVar;
        this.dBM = this.dPK.aua();
        this.dBD = this.dPK.aud();
        this.dQE = this.dPK.aub();
        this.dBL = this.dPK.atY();
        this.dQF = this.dPK.auc();
        this.dQG = this.dPK.atZ();
    }
}
