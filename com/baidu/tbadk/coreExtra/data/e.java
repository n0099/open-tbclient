package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class e {
    private final TbPageContext<?> aat;
    private final int aoS;
    private final int aoT;
    private final boolean aoU;

    public e(TbPageContext<?> tbPageContext, int i, int i2, boolean z) {
        this.aat = tbPageContext;
        this.aoS = i;
        this.aoT = i2;
        this.aoU = z;
    }

    public e(TbPageContext<?> tbPageContext, int i, int i2) {
        this(tbPageContext, i, i2, false);
    }

    public TbPageContext<?> xD() {
        return this.aat;
    }

    public int xE() {
        return this.aoS;
    }

    public int xF() {
        return this.aoT;
    }

    public boolean isAvailable() {
        return this.aat != null && this.aoS > 0 && this.aoT > 0;
    }
}
