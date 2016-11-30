package com.baidu.tieba.frs.e;

import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.ch;
import com.baidu.tieba.frs.j.af;
import com.baidu.tieba.frs.j.w;
/* loaded from: classes.dex */
public class s {
    protected final au bRW;
    protected final i bSh;
    protected final com.baidu.tieba.frs.j.n bSi;
    protected final af bSj;
    protected final w bSk;
    protected final com.baidu.tieba.frs.entelechy.b.d bSm;
    protected final FrsActivity bZY;
    protected final ch cgK;
    protected final h cgL;

    public s(FrsActivity frsActivity) {
        if (frsActivity == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.bZY = frsActivity;
        this.bSk = this.bZY.abT();
        this.bSi = this.bZY.abW();
        this.bRW = this.bZY.abZ();
        this.bSj = this.bZY.abU();
        this.bSm = this.bZY.abX();
        this.bSh = this.bZY.abS();
        this.cgK = this.bZY.abY();
        this.cgL = this.bZY.abV();
    }
}
