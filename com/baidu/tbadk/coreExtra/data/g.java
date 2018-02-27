package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    private final TbPageContext<?> aRG;
    private final int bhi;
    private final int bhj;
    private final boolean bhk;

    public g(TbPageContext<?> tbPageContext, int i, int i2, boolean z) {
        this.aRG = tbPageContext;
        this.bhi = i;
        this.bhj = i2;
        this.bhk = z;
    }

    public g(TbPageContext<?> tbPageContext, int i, int i2) {
        this(tbPageContext, i, i2, false);
    }

    public TbPageContext<?> FE() {
        return this.aRG;
    }

    public int FF() {
        return this.bhi;
    }

    public int FG() {
        return this.bhj;
    }

    public boolean isAvailable() {
        return this.aRG != null && this.bhi > 0 && this.bhj > 0;
    }
}
