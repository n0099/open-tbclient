package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class i {
    private final int cfR;
    private final int cfS;
    private final TbPageContext<?> mContext;

    public TbPageContext<?> amk() {
        return this.mContext;
    }

    public int aml() {
        return this.cfR;
    }

    public int amm() {
        return this.cfS;
    }

    public boolean isAvailable() {
        return this.mContext != null && this.cfR > 0 && this.cfS > 0;
    }
}
