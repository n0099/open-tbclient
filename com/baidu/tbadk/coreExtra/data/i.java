package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class i {
    private final int aNJ;
    private final int aNK;
    private final TbPageContext<?> mContext;

    public TbPageContext<?> GC() {
        return this.mContext;
    }

    public int GD() {
        return this.aNJ;
    }

    public int GE() {
        return this.aNK;
    }

    public boolean isAvailable() {
        return this.mContext != null && this.aNJ > 0 && this.aNK > 0;
    }
}
