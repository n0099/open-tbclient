package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    private final TbPageContext<?> aRI;
    private final int bhl;
    private final int bhm;
    private final boolean bhn;

    public g(TbPageContext<?> tbPageContext, int i, int i2, boolean z) {
        this.aRI = tbPageContext;
        this.bhl = i;
        this.bhm = i2;
        this.bhn = z;
    }

    public g(TbPageContext<?> tbPageContext, int i, int i2) {
        this(tbPageContext, i, i2, false);
    }

    public TbPageContext<?> FF() {
        return this.aRI;
    }

    public int FG() {
        return this.bhl;
    }

    public int FH() {
        return this.bhm;
    }

    public boolean isAvailable() {
        return this.aRI != null && this.bhl > 0 && this.bhm > 0;
    }
}
