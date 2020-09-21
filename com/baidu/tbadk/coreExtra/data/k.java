package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class k {
    private final int dmR;
    private final int dmS;
    private final TbPageContext<?> ehG;

    public TbPageContext<?> bnz() {
        return this.ehG;
    }

    public int aJP() {
        return this.dmS;
    }

    public int aJO() {
        return this.dmR;
    }

    public boolean isAvailable() {
        return this.ehG != null && this.dmS > 0 && this.dmR > 0;
    }
}
