package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    private final TbPageContext<?> abX;
    private final int ark;
    private final int arl;
    private final boolean arm;

    public g(TbPageContext<?> tbPageContext, int i, int i2, boolean z) {
        this.abX = tbPageContext;
        this.ark = i;
        this.arl = i2;
        this.arm = z;
    }

    public g(TbPageContext<?> tbPageContext, int i, int i2) {
        this(tbPageContext, i, i2, false);
    }

    public TbPageContext<?> xR() {
        return this.abX;
    }

    public int xS() {
        return this.ark;
    }

    public int xT() {
        return this.arl;
    }

    public boolean isAvailable() {
        return this.abX != null && this.ark > 0 && this.arl > 0;
    }
}
