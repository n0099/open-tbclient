package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class e {
    private final TbPageContext<?> abz;
    private final int aqA;
    private final boolean aqB;
    private final int aqz;

    public e(TbPageContext<?> tbPageContext, int i, int i2, boolean z) {
        this.abz = tbPageContext;
        this.aqz = i;
        this.aqA = i2;
        this.aqB = z;
    }

    public e(TbPageContext<?> tbPageContext, int i, int i2) {
        this(tbPageContext, i, i2, false);
    }

    public TbPageContext<?> xH() {
        return this.abz;
    }

    public int xI() {
        return this.aqz;
    }

    public int xJ() {
        return this.aqA;
    }

    public boolean isAvailable() {
        return this.abz != null && this.aqz > 0 && this.aqA > 0;
    }
}
