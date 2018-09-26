package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.k;
/* loaded from: classes2.dex */
public class h {
    protected final FrsFragment dKj;
    protected final com.baidu.tieba.frs.vc.j dLg;
    protected final an dLh;
    protected final c dLi;
    protected final k dsl;
    protected final FrsModelController dsw;
    protected final com.baidu.tieba.frs.vc.f dsx;

    public h(FrsFragment frsFragment) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.dKj = frsFragment;
        this.dsx = this.dKj.awb();
        this.dsl = this.dKj.awe();
        this.dLg = this.dKj.awc();
        this.dsw = this.dKj.avZ();
        this.dLh = this.dKj.awd();
        this.dLi = this.dKj.awa();
    }
}
