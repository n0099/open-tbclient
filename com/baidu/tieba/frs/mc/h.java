package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.k;
/* loaded from: classes2.dex */
public class h {
    protected final FrsFragment dAK;
    protected final com.baidu.tieba.frs.vc.j dBH;
    protected final an dBI;
    protected final c dBJ;
    protected final k djA;
    protected final FrsModelController djL;
    protected final com.baidu.tieba.frs.vc.f djM;

    public h(FrsFragment frsFragment) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.dAK = frsFragment;
        this.djM = this.dAK.atF();
        this.djA = this.dAK.atI();
        this.dBH = this.dAK.atG();
        this.djL = this.dAK.atD();
        this.dBI = this.dAK.atH();
        this.dBJ = this.dAK.atE();
    }
}
