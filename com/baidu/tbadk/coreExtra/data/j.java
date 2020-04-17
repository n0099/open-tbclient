package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class j {
    private final int cGP;
    private final int cGQ;
    private final TbPageContext<?> duG;

    public TbPageContext<?> aRS() {
        return this.duG;
    }

    public int asL() {
        return this.cGQ;
    }

    public int asK() {
        return this.cGP;
    }

    public boolean isAvailable() {
        return this.duG != null && this.cGQ > 0 && this.cGP > 0;
    }
}
