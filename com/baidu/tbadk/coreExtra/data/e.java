package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class e {
    private final TbPageContext<?> aaI;
    private final boolean aoA;
    private final int aoy;
    private final int aoz;

    public e(TbPageContext<?> tbPageContext, int i, int i2, boolean z) {
        this.aaI = tbPageContext;
        this.aoy = i;
        this.aoz = i2;
        this.aoA = z;
    }

    public e(TbPageContext<?> tbPageContext, int i, int i2) {
        this(tbPageContext, i, i2, false);
    }

    public TbPageContext<?> xR() {
        return this.aaI;
    }

    public int xS() {
        return this.aoy;
    }

    public int xT() {
        return this.aoz;
    }

    public boolean isAvailable() {
        return this.aaI != null && this.aoy > 0 && this.aoz > 0;
    }
}
