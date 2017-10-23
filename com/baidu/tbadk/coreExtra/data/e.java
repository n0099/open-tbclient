package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class e {
    private final TbPageContext<?> abm;
    private final int aqn;
    private final int aqo;
    private final boolean aqp;

    public e(TbPageContext<?> tbPageContext, int i, int i2, boolean z) {
        this.abm = tbPageContext;
        this.aqn = i;
        this.aqo = i2;
        this.aqp = z;
    }

    public e(TbPageContext<?> tbPageContext, int i, int i2) {
        this(tbPageContext, i, i2, false);
    }

    public TbPageContext<?> xA() {
        return this.abm;
    }

    public int xB() {
        return this.aqn;
    }

    public int xC() {
        return this.aqo;
    }

    public boolean isAvailable() {
        return this.abm != null && this.aqn > 0 && this.aqo > 0;
    }
}
