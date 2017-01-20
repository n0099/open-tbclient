package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class e {
    private final TbPageContext<?> Fp;
    private final int ajb;
    private final int ajc;
    private final boolean ajd;

    public e(TbPageContext<?> tbPageContext, int i, int i2, boolean z) {
        this.Fp = tbPageContext;
        this.ajb = i;
        this.ajc = i2;
        this.ajd = z;
    }

    public e(TbPageContext<?> tbPageContext, int i, int i2) {
        this(tbPageContext, i, i2, false);
    }

    public TbPageContext<?> xv() {
        return this.Fp;
    }

    public int xw() {
        return this.ajb;
    }

    public int xx() {
        return this.ajc;
    }

    public boolean isAvailable() {
        return this.Fp != null && this.ajb > 0 && this.ajc > 0;
    }
}
