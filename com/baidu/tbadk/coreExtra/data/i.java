package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class i {
    private final int ceL;
    private final int ceM;
    private final TbPageContext<?> mContext;

    public TbPageContext<?> alf() {
        return this.mContext;
    }

    public int alg() {
        return this.ceL;
    }

    public int alh() {
        return this.ceM;
    }

    public boolean isAvailable() {
        return this.mContext != null && this.ceL > 0 && this.ceM > 0;
    }
}
