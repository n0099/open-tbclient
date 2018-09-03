package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    private final int aBK;
    private final int aBL;
    private final boolean aBM;
    private final TbPageContext<?> mContext;

    public g(TbPageContext<?> tbPageContext, int i, int i2, boolean z) {
        this.mContext = tbPageContext;
        this.aBK = i;
        this.aBL = i2;
        this.aBM = z;
    }

    public g(TbPageContext<?> tbPageContext, int i, int i2) {
        this(tbPageContext, i, i2, false);
    }

    public TbPageContext<?> BX() {
        return this.mContext;
    }

    public int BY() {
        return this.aBK;
    }

    public int BZ() {
        return this.aBL;
    }

    public boolean isAvailable() {
        return this.mContext != null && this.aBK > 0 && this.aBL > 0;
    }
}
