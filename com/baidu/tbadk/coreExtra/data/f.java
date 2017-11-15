package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class f {
    private final TbPageContext<?> abI;
    private final int aqN;
    private final int aqO;
    private final boolean aqP;

    public f(TbPageContext<?> tbPageContext, int i, int i2, boolean z) {
        this.abI = tbPageContext;
        this.aqN = i;
        this.aqO = i2;
        this.aqP = z;
    }

    public f(TbPageContext<?> tbPageContext, int i, int i2) {
        this(tbPageContext, i, i2, false);
    }

    public TbPageContext<?> xP() {
        return this.abI;
    }

    public int xQ() {
        return this.aqN;
    }

    public int xR() {
        return this.aqO;
    }

    public boolean isAvailable() {
        return this.abI != null && this.aqN > 0 && this.aqO > 0;
    }
}
