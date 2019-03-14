package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ak;
/* loaded from: classes4.dex */
public class j {
    protected final com.baidu.tieba.frs.k eYS;
    protected final FrsModelController eZj;
    protected final com.baidu.tieba.frs.vc.f eZk;
    protected final FrsFragment fqS;
    protected final com.baidu.tieba.frs.vc.k fsc;
    protected final ak fsd;
    protected final c fse;

    public j(FrsFragment frsFragment) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.fqS = frsFragment;
        this.eZk = this.fqS.bcr();
        this.eYS = this.fqS.bcu();
        this.fsc = this.fqS.bcs();
        this.eZj = this.fqS.bcp();
        this.fsd = this.fqS.bct();
        this.fse = this.fqS.bcq();
    }
}
