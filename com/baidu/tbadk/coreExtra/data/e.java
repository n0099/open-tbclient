package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class e {
    private final TbPageContext<?> acr;
    private final int arN;
    private final int arO;
    private final boolean arP;

    public e(TbPageContext<?> tbPageContext, int i, int i2, boolean z) {
        this.acr = tbPageContext;
        this.arN = i;
        this.arO = i2;
        this.arP = z;
    }

    public e(TbPageContext<?> tbPageContext, int i, int i2) {
        this(tbPageContext, i, i2, false);
    }

    public TbPageContext<?> yg() {
        return this.acr;
    }

    public int yh() {
        return this.arN;
    }

    public int yi() {
        return this.arO;
    }

    public boolean isAvailable() {
        return this.acr != null && this.arN > 0 && this.arO > 0;
    }
}
