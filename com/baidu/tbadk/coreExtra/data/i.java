package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class i {
    private final int ceM;
    private final int ceN;
    private final TbPageContext<?> mContext;

    public TbPageContext<?> alf() {
        return this.mContext;
    }

    public int alg() {
        return this.ceM;
    }

    public int alh() {
        return this.ceN;
    }

    public boolean isAvailable() {
        return this.mContext != null && this.ceM > 0 && this.ceN > 0;
    }
}
