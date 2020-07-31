package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class j {
    private final TbPageContext<?> dVN;
    private final int daB;
    private final int daC;

    public TbPageContext<?> bdZ() {
        return this.dVN;
    }

    public int aAu() {
        return this.daC;
    }

    public int aAt() {
        return this.daB;
    }

    public boolean isAvailable() {
        return this.dVN != null && this.daC > 0 && this.daB > 0;
    }
}
