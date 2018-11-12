package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class i {
    private final int aKj;
    private final int aKk;
    private final boolean aKl;
    private final TbPageContext<?> mContext;

    public i(TbPageContext<?> tbPageContext, int i, int i2, boolean z) {
        this.mContext = tbPageContext;
        this.aKj = i;
        this.aKk = i2;
        this.aKl = z;
    }

    public i(TbPageContext<?> tbPageContext, int i, int i2) {
        this(tbPageContext, i, i2, false);
    }

    public TbPageContext<?> Fy() {
        return this.mContext;
    }

    public int Fz() {
        return this.aKj;
    }

    public int FA() {
        return this.aKk;
    }

    public boolean isAvailable() {
        return this.mContext != null && this.aKj > 0 && this.aKk > 0;
    }
}
