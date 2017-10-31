package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class e {
    private final TbPageContext<?> abI;
    private final int aqH;
    private final int aqI;
    private final boolean aqJ;

    public e(TbPageContext<?> tbPageContext, int i, int i2, boolean z) {
        this.abI = tbPageContext;
        this.aqH = i;
        this.aqI = i2;
        this.aqJ = z;
    }

    public e(TbPageContext<?> tbPageContext, int i, int i2) {
        this(tbPageContext, i, i2, false);
    }

    public TbPageContext<?> xH() {
        return this.abI;
    }

    public int xI() {
        return this.aqH;
    }

    public int xJ() {
        return this.aqI;
    }

    public boolean isAvailable() {
        return this.abI != null && this.aqH > 0 && this.aqI > 0;
    }
}
