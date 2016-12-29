package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class e {
    private final TbPageContext<?> Gf;
    private final int ajO;
    private final int ajP;
    private final boolean ajQ;

    public e(TbPageContext<?> tbPageContext, int i, int i2, boolean z) {
        this.Gf = tbPageContext;
        this.ajO = i;
        this.ajP = i2;
        this.ajQ = z;
    }

    public e(TbPageContext<?> tbPageContext, int i, int i2) {
        this(tbPageContext, i, i2, false);
    }

    public TbPageContext<?> xz() {
        return this.Gf;
    }

    public int xA() {
        return this.ajO;
    }

    public int xB() {
        return this.ajP;
    }

    public boolean isAvailable() {
        return this.Gf != null && this.ajO > 0 && this.ajP > 0;
    }
}
