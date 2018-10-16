package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class h {
    private final int aJt;
    private final int aJu;
    private final boolean aJv;
    private final TbPageContext<?> mContext;

    public h(TbPageContext<?> tbPageContext, int i, int i2, boolean z) {
        this.mContext = tbPageContext;
        this.aJt = i;
        this.aJu = i2;
        this.aJv = z;
    }

    public h(TbPageContext<?> tbPageContext, int i, int i2) {
        this(tbPageContext, i, i2, false);
    }

    public TbPageContext<?> Fm() {
        return this.mContext;
    }

    public int Fn() {
        return this.aJt;
    }

    public int Fo() {
        return this.aJu;
    }

    public boolean isAvailable() {
        return this.mContext != null && this.aJt > 0 && this.aJu > 0;
    }
}
