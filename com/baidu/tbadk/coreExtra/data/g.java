package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    private final int aBa;
    private final int aBb;
    private final boolean aBc;
    private final TbPageContext<?> mContext;

    public g(TbPageContext<?> tbPageContext, int i, int i2, boolean z) {
        this.mContext = tbPageContext;
        this.aBa = i;
        this.aBb = i2;
        this.aBc = z;
    }

    public g(TbPageContext<?> tbPageContext, int i, int i2) {
        this(tbPageContext, i, i2, false);
    }

    public TbPageContext<?> BR() {
        return this.mContext;
    }

    public int BS() {
        return this.aBa;
    }

    public int BT() {
        return this.aBb;
    }

    public boolean isAvailable() {
        return this.mContext != null && this.aBa > 0 && this.aBb > 0;
    }
}
