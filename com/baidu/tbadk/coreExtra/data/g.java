package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    private final int aBN;
    private final int aBO;
    private final boolean aBP;
    private final TbPageContext<?> mContext;

    public g(TbPageContext<?> tbPageContext, int i, int i2, boolean z) {
        this.mContext = tbPageContext;
        this.aBN = i;
        this.aBO = i2;
        this.aBP = z;
    }

    public g(TbPageContext<?> tbPageContext, int i, int i2) {
        this(tbPageContext, i, i2, false);
    }

    public TbPageContext<?> Ca() {
        return this.mContext;
    }

    public int Cb() {
        return this.aBN;
    }

    public int Cc() {
        return this.aBO;
    }

    public boolean isAvailable() {
        return this.mContext != null && this.aBN > 0 && this.aBO > 0;
    }
}
