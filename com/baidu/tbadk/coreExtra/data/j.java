package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class j {
    private final int cVP;
    private final int cVQ;
    private final TbPageContext<?> dPv;

    public TbPageContext<?> bac() {
        return this.dPv;
    }

    public int axx() {
        return this.cVQ;
    }

    public int axw() {
        return this.cVP;
    }

    public boolean isAvailable() {
        return this.dPv != null && this.cVQ > 0 && this.cVP > 0;
    }
}
