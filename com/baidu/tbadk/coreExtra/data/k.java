package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class k {
    private final int dHu;
    private final int dHv;
    private final TbPageContext<?> eCn;

    public TbPageContext<?> bsc() {
        return this.eCn;
    }

    public int aOs() {
        return this.dHv;
    }

    public int aOr() {
        return this.dHu;
    }

    public boolean isAvailable() {
        return this.eCn != null && this.dHv > 0 && this.dHu > 0;
    }
}
