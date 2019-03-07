package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class i {
    private final int bWM;
    private final int bWN;
    private final TbPageContext<?> mContext;

    public TbPageContext<?> agj() {
        return this.mContext;
    }

    public int agk() {
        return this.bWM;
    }

    public int agl() {
        return this.bWN;
    }

    public boolean isAvailable() {
        return this.mContext != null && this.bWM > 0 && this.bWN > 0;
    }
}
