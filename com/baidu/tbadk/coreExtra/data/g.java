package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    private final TbPageContext<?> aQq;
    private final int bfn;
    private final int bfo;
    private final boolean bfp;

    public g(TbPageContext<?> tbPageContext, int i, int i2, boolean z) {
        this.aQq = tbPageContext;
        this.bfn = i;
        this.bfo = i2;
        this.bfp = z;
    }

    public g(TbPageContext<?> tbPageContext, int i, int i2) {
        this(tbPageContext, i, i2, false);
    }

    public TbPageContext<?> Fq() {
        return this.aQq;
    }

    public int Fr() {
        return this.bfn;
    }

    public int Fs() {
        return this.bfo;
    }

    public boolean isAvailable() {
        return this.aQq != null && this.bfn > 0 && this.bfo > 0;
    }
}
