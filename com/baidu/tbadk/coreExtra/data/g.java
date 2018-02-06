package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    private final TbPageContext<?> aRR;
    private final int bhu;
    private final int bhv;
    private final boolean bhw;

    public g(TbPageContext<?> tbPageContext, int i, int i2, boolean z) {
        this.aRR = tbPageContext;
        this.bhu = i;
        this.bhv = i2;
        this.bhw = z;
    }

    public g(TbPageContext<?> tbPageContext, int i, int i2) {
        this(tbPageContext, i, i2, false);
    }

    public TbPageContext<?> FF() {
        return this.aRR;
    }

    public int FG() {
        return this.bhu;
    }

    public int FH() {
        return this.bhv;
    }

    public boolean isAvailable() {
        return this.aRR != null && this.bhu > 0 && this.bhv > 0;
    }
}
