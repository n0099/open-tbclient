package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ax;
import com.baidu.tieba.frs.q;
/* loaded from: classes22.dex */
public class j {
    protected final FrsModelController iBL;
    protected final com.baidu.tieba.frs.vc.h iBM;
    protected final q iBs;
    protected final FrsFragment iWX;
    protected final com.baidu.tieba.frs.vc.n iYh;
    protected final ax iYi;
    protected final c iYj;

    public j(FrsFragment frsFragment) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.iWX = frsFragment;
        this.iBM = this.iWX.cvH();
        this.iBs = this.iWX.cvK();
        this.iYh = this.iWX.cvI();
        this.iBL = this.iWX.cvF();
        this.iYi = this.iWX.cvJ();
        this.iYj = this.iWX.cvG();
    }
}
