package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class i {
    private final int cgR;
    private final int cgS;
    private final TbPageContext<?> mContext;

    public TbPageContext<?> amy() {
        return this.mContext;
    }

    public int amz() {
        return this.cgR;
    }

    public int amA() {
        return this.cgS;
    }

    public boolean isAvailable() {
        return this.mContext != null && this.cgR > 0 && this.cgS > 0;
    }
}
