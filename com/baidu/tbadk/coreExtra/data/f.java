package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class f {
    private final TbPageContext<?> acd;
    private final int arf;
    private final int arg;
    private final boolean arh;

    public f(TbPageContext<?> tbPageContext, int i, int i2, boolean z) {
        this.acd = tbPageContext;
        this.arf = i;
        this.arg = i2;
        this.arh = z;
    }

    public f(TbPageContext<?> tbPageContext, int i, int i2) {
        this(tbPageContext, i, i2, false);
    }

    public TbPageContext<?> xQ() {
        return this.acd;
    }

    public int xR() {
        return this.arf;
    }

    public int xS() {
        return this.arg;
    }

    public boolean isAvailable() {
        return this.acd != null && this.arf > 0 && this.arg > 0;
    }
}
