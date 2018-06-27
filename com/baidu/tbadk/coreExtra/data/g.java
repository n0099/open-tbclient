package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    private final int aBT;
    private final int aBU;
    private final boolean aBV;
    private final TbPageContext<?> mContext;

    public g(TbPageContext<?> tbPageContext, int i, int i2, boolean z) {
        this.mContext = tbPageContext;
        this.aBT = i;
        this.aBU = i2;
        this.aBV = z;
    }

    public g(TbPageContext<?> tbPageContext, int i, int i2) {
        this(tbPageContext, i, i2, false);
    }

    public TbPageContext<?> Ci() {
        return this.mContext;
    }

    public int Cj() {
        return this.aBT;
    }

    public int Ck() {
        return this.aBU;
    }

    public boolean isAvailable() {
        return this.mContext != null && this.aBT > 0 && this.aBU > 0;
    }
}
