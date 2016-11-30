package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class e {
    private final TbPageContext<?> Gf;
    private final int akm;
    private final int akn;
    private final boolean ako;

    public e(TbPageContext<?> tbPageContext, int i, int i2, boolean z) {
        this.Gf = tbPageContext;
        this.akm = i;
        this.akn = i2;
        this.ako = z;
    }

    public e(TbPageContext<?> tbPageContext, int i, int i2) {
        this(tbPageContext, i, i2, false);
    }

    public TbPageContext<?> xL() {
        return this.Gf;
    }

    public int xM() {
        return this.akm;
    }

    public int xN() {
        return this.akn;
    }

    public boolean isAvailable() {
        return this.Gf != null && this.akm > 0 && this.akn > 0;
    }
}
