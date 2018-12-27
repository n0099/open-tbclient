package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class i {
    private final int aNL;
    private final int aNM;
    private final TbPageContext<?> mContext;

    public TbPageContext<?> GD() {
        return this.mContext;
    }

    public int GE() {
        return this.aNL;
    }

    public int GF() {
        return this.aNM;
    }

    public boolean isAvailable() {
        return this.mContext != null && this.aNL > 0 && this.aNM > 0;
    }
}
