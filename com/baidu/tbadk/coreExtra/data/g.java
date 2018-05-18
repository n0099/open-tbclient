package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    private final int asT;
    private final int asU;
    private final boolean asV;
    private final TbPageContext<?> mContext;

    public g(TbPageContext<?> tbPageContext, int i, int i2, boolean z) {
        this.mContext = tbPageContext;
        this.asT = i;
        this.asU = i2;
        this.asV = z;
    }

    public g(TbPageContext<?> tbPageContext, int i, int i2) {
        this(tbPageContext, i, i2, false);
    }

    public TbPageContext<?> yr() {
        return this.mContext;
    }

    public int ys() {
        return this.asT;
    }

    public int yt() {
        return this.asU;
    }

    public boolean isAvailable() {
        return this.mContext != null && this.asT > 0 && this.asU > 0;
    }
}
