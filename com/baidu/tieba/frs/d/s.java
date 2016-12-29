package com.baidu.tieba.frs.d;

import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ax;
import com.baidu.tieba.frs.cg;
import com.baidu.tieba.frs.h.ab;
import com.baidu.tieba.frs.h.ak;
/* loaded from: classes.dex */
public class s {
    protected final FrsActivity bFI;
    protected final cg bMt;
    protected final h bMu;
    protected final ax byg;
    protected final i byr;
    protected final com.baidu.tieba.frs.h.s bys;
    protected final ak byt;
    protected final ab byu;
    protected final com.baidu.tieba.frs.entelechy.b.d byw;

    public s(FrsActivity frsActivity) {
        if (frsActivity == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.bFI = frsActivity;
        this.byu = this.bFI.Wi();
        this.bys = this.bFI.Wl();
        this.byg = this.bFI.Wo();
        this.byt = this.bFI.Wj();
        this.byw = this.bFI.Wm();
        this.byr = this.bFI.Wh();
        this.bMt = this.bFI.Wn();
        this.bMu = this.bFI.Wk();
    }
}
