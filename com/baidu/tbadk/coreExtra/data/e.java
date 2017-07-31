package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class e {
    private final TbPageContext<?> acp;
    private final int arM;
    private final int arN;
    private final boolean arO;

    public e(TbPageContext<?> tbPageContext, int i, int i2, boolean z) {
        this.acp = tbPageContext;
        this.arM = i;
        this.arN = i2;
        this.arO = z;
    }

    public e(TbPageContext<?> tbPageContext, int i, int i2) {
        this(tbPageContext, i, i2, false);
    }

    public TbPageContext<?> yg() {
        return this.acp;
    }

    public int yh() {
        return this.arM;
    }

    public int yi() {
        return this.arN;
    }

    public boolean isAvailable() {
        return this.acp != null && this.arM > 0 && this.arN > 0;
    }
}
