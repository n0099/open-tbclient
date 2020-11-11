package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ax;
import com.baidu.tieba.frs.q;
/* loaded from: classes22.dex */
public class j {
    protected final FrsModelController iHI;
    protected final com.baidu.tieba.frs.vc.h iHJ;
    protected final q iHp;
    protected final FrsFragment jcU;
    protected final com.baidu.tieba.frs.vc.n jee;
    protected final ax jef;
    protected final c jeg;

    public j(FrsFragment frsFragment) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.jcU = frsFragment;
        this.iHJ = this.jcU.cyi();
        this.iHp = this.jcU.cyl();
        this.jee = this.jcU.cyj();
        this.iHI = this.jcU.cyg();
        this.jef = this.jcU.cyk();
        this.jeg = this.jcU.cyh();
    }
}
