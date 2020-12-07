package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class k {
    private final int dSB;
    private final int dSC;
    private final TbPageContext<?> eNx;

    public TbPageContext<?> bxs() {
        return this.eNx;
    }

    public int aTp() {
        return this.dSC;
    }

    public int aTo() {
        return this.dSB;
    }

    public boolean isAvailable() {
        return this.eNx != null && this.dSC > 0 && this.dSB > 0;
    }
}
