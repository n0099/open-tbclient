package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.av;
import com.baidu.tieba.frs.p;
/* loaded from: classes16.dex */
public class j {
    protected final FrsModelController hFS;
    protected final com.baidu.tieba.frs.vc.h hFT;
    protected final p hFz;
    protected final FrsFragment iac;
    protected final com.baidu.tieba.frs.vc.n ibn;
    protected final av ibo;
    protected final c ibp;

    public j(FrsFragment frsFragment) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.iac = frsFragment;
        this.hFT = this.iac.cbt();
        this.hFz = this.iac.cbw();
        this.ibn = this.iac.cbu();
        this.hFS = this.iac.cbr();
        this.ibo = this.iac.cbv();
        this.ibp = this.iac.cbs();
    }
}
