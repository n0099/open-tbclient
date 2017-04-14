package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class e {
    private final TbPageContext<?> aaX;
    private final int aoN;
    private final int aoO;
    private final boolean aoP;

    public e(TbPageContext<?> tbPageContext, int i, int i2, boolean z) {
        this.aaX = tbPageContext;
        this.aoN = i;
        this.aoO = i2;
        this.aoP = z;
    }

    public e(TbPageContext<?> tbPageContext, int i, int i2) {
        this(tbPageContext, i, i2, false);
    }

    public TbPageContext<?> yp() {
        return this.aaX;
    }

    public int yq() {
        return this.aoN;
    }

    public int yr() {
        return this.aoO;
    }

    public boolean isAvailable() {
        return this.aaX != null && this.aoN > 0 && this.aoO > 0;
    }
}
