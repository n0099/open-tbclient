package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ak;
/* loaded from: classes4.dex */
public class j {
    protected final com.baidu.tieba.frs.k eYT;
    protected final FrsModelController eZk;
    protected final com.baidu.tieba.frs.vc.f eZl;
    protected final FrsFragment fqT;
    protected final com.baidu.tieba.frs.vc.k fsd;
    protected final ak fse;
    protected final c fsf;

    public j(FrsFragment frsFragment) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.fqT = frsFragment;
        this.eZl = this.fqT.bcs();
        this.eYT = this.fqT.bcv();
        this.fsd = this.fqT.bct();
        this.eZk = this.fqT.bcq();
        this.fse = this.fqT.bcu();
        this.fsf = this.fqT.bcr();
    }
}
