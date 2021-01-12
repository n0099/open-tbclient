package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class k {
    private final int dWM;
    private final int dWN;
    private final TbPageContext<?> eSJ;

    public TbPageContext<?> bvT() {
        return this.eSJ;
    }

    public int aRQ() {
        return this.dWN;
    }

    public int aRP() {
        return this.dWM;
    }

    public boolean isAvailable() {
        return this.eSJ != null && this.dWN > 0 && this.dWM > 0;
    }
}
