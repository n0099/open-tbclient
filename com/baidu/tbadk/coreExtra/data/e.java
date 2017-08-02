package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class e {
    private final TbPageContext<?> aaS;
    private final int aqu;
    private final int aqv;
    private final boolean aqw;

    public e(TbPageContext<?> tbPageContext, int i, int i2, boolean z) {
        this.aaS = tbPageContext;
        this.aqu = i;
        this.aqv = i2;
        this.aqw = z;
    }

    public e(TbPageContext<?> tbPageContext, int i, int i2) {
        this(tbPageContext, i, i2, false);
    }

    public TbPageContext<?> xY() {
        return this.aaS;
    }

    public int xZ() {
        return this.aqu;
    }

    public int ya() {
        return this.aqv;
    }

    public boolean isAvailable() {
        return this.aaS != null && this.aqu > 0 && this.aqv > 0;
    }
}
