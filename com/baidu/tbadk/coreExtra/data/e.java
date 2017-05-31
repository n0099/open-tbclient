package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class e {
    private final TbPageContext<?> aas;
    private final int aoC;
    private final int aoD;
    private final boolean aoE;

    public e(TbPageContext<?> tbPageContext, int i, int i2, boolean z) {
        this.aas = tbPageContext;
        this.aoC = i;
        this.aoD = i2;
        this.aoE = z;
    }

    public e(TbPageContext<?> tbPageContext, int i, int i2) {
        this(tbPageContext, i, i2, false);
    }

    public TbPageContext<?> xw() {
        return this.aas;
    }

    public int xx() {
        return this.aoC;
    }

    public int xy() {
        return this.aoD;
    }

    public boolean isAvailable() {
        return this.aas != null && this.aoC > 0 && this.aoD > 0;
    }
}
