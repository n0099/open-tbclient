package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    private final TbPageContext<?> aQp;
    private final int bft;
    private final int bfu;
    private final boolean bfv;

    public g(TbPageContext<?> tbPageContext, int i, int i2, boolean z) {
        this.aQp = tbPageContext;
        this.bft = i;
        this.bfu = i2;
        this.bfv = z;
    }

    public g(TbPageContext<?> tbPageContext, int i, int i2) {
        this(tbPageContext, i, i2, false);
    }

    public TbPageContext<?> Fh() {
        return this.aQp;
    }

    public int Fi() {
        return this.bft;
    }

    public int Fj() {
        return this.bfu;
    }

    public boolean isAvailable() {
        return this.aQp != null && this.bft > 0 && this.bfu > 0;
    }
}
