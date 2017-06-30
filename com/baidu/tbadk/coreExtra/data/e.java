package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class e {
    private final TbPageContext<?> aat;
    private final int apD;
    private final int apE;
    private final boolean apF;

    public e(TbPageContext<?> tbPageContext, int i, int i2, boolean z) {
        this.aat = tbPageContext;
        this.apD = i;
        this.apE = i2;
        this.apF = z;
    }

    public e(TbPageContext<?> tbPageContext, int i, int i2) {
        this(tbPageContext, i, i2, false);
    }

    public TbPageContext<?> xN() {
        return this.aat;
    }

    public int xO() {
        return this.apD;
    }

    public int xP() {
        return this.apE;
    }

    public boolean isAvailable() {
        return this.aat != null && this.apD > 0 && this.apE > 0;
    }
}
