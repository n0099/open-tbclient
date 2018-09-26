package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class h {
    private final int aEQ;
    private final int aER;
    private final boolean aES;
    private final TbPageContext<?> mContext;

    public h(TbPageContext<?> tbPageContext, int i, int i2, boolean z) {
        this.mContext = tbPageContext;
        this.aEQ = i;
        this.aER = i2;
        this.aES = z;
    }

    public h(TbPageContext<?> tbPageContext, int i, int i2) {
        this(tbPageContext, i, i2, false);
    }

    public TbPageContext<?> Dl() {
        return this.mContext;
    }

    public int Dm() {
        return this.aEQ;
    }

    public int Dn() {
        return this.aER;
    }

    public boolean isAvailable() {
        return this.mContext != null && this.aEQ > 0 && this.aER > 0;
    }
}
