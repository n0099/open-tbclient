package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class i {
    private final int aOo;
    private final int aOp;
    private final TbPageContext<?> mContext;

    public TbPageContext<?> GQ() {
        return this.mContext;
    }

    public int GR() {
        return this.aOo;
    }

    public int GS() {
        return this.aOp;
    }

    public boolean isAvailable() {
        return this.mContext != null && this.aOo > 0 && this.aOp > 0;
    }
}
