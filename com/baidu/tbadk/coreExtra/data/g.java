package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    private final TbPageContext<?> aQs;
    private final int bfB;
    private final int bfC;
    private final boolean bfD;

    public g(TbPageContext<?> tbPageContext, int i, int i2, boolean z) {
        this.aQs = tbPageContext;
        this.bfB = i;
        this.bfC = i2;
        this.bfD = z;
    }

    public g(TbPageContext<?> tbPageContext, int i, int i2) {
        this(tbPageContext, i, i2, false);
    }

    public TbPageContext<?> Fj() {
        return this.aQs;
    }

    public int Fk() {
        return this.bfB;
    }

    public int Fl() {
        return this.bfC;
    }

    public boolean isAvailable() {
        return this.aQs != null && this.bfB > 0 && this.bfC > 0;
    }
}
