package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class i {
    private final int bWP;
    private final int bWQ;
    private final TbPageContext<?> mContext;

    public TbPageContext<?> agg() {
        return this.mContext;
    }

    public int agh() {
        return this.bWP;
    }

    public int agi() {
        return this.bWQ;
    }

    public boolean isAvailable() {
        return this.mContext != null && this.bWP > 0 && this.bWQ > 0;
    }
}
