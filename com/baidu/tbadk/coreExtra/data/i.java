package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class i {
    private final int bWN;
    private final int bWO;
    private final TbPageContext<?> mContext;

    public TbPageContext<?> agj() {
        return this.mContext;
    }

    public int agk() {
        return this.bWN;
    }

    public int agl() {
        return this.bWO;
    }

    public boolean isAvailable() {
        return this.mContext != null && this.bWN > 0 && this.bWO > 0;
    }
}
