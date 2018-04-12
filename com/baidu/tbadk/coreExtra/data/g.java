package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    private final TbPageContext<?> adf;
    private final int asS;
    private final int asT;
    private final boolean asU;

    public g(TbPageContext<?> tbPageContext, int i, int i2, boolean z) {
        this.adf = tbPageContext;
        this.asS = i;
        this.asT = i2;
        this.asU = z;
    }

    public g(TbPageContext<?> tbPageContext, int i, int i2) {
        this(tbPageContext, i, i2, false);
    }

    public TbPageContext<?> ys() {
        return this.adf;
    }

    public int yt() {
        return this.asS;
    }

    public int yu() {
        return this.asT;
    }

    public boolean isAvailable() {
        return this.adf != null && this.asS > 0 && this.asT > 0;
    }
}
