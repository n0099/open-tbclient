package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class i {
    private final int cfY;
    private final int cfZ;
    private final TbPageContext<?> mContext;

    public TbPageContext<?> amm() {
        return this.mContext;
    }

    public int amn() {
        return this.cfY;
    }

    public int amo() {
        return this.cfZ;
    }

    public boolean isAvailable() {
        return this.mContext != null && this.cfY > 0 && this.cfZ > 0;
    }
}
