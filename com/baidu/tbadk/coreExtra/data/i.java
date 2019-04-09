package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class i {
    private final int bWQ;
    private final int bWR;
    private final TbPageContext<?> mContext;

    public TbPageContext<?> agg() {
        return this.mContext;
    }

    public int agh() {
        return this.bWQ;
    }

    public int agi() {
        return this.bWR;
    }

    public boolean isAvailable() {
        return this.mContext != null && this.bWQ > 0 && this.bWR > 0;
    }
}
