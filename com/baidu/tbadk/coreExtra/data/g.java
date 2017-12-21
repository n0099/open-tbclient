package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    private final TbPageContext<?> aca;
    private final int arn;
    private final int aro;
    private final boolean arp;

    public g(TbPageContext<?> tbPageContext, int i, int i2, boolean z) {
        this.aca = tbPageContext;
        this.arn = i;
        this.aro = i2;
        this.arp = z;
    }

    public g(TbPageContext<?> tbPageContext, int i, int i2) {
        this(tbPageContext, i, i2, false);
    }

    public TbPageContext<?> xR() {
        return this.aca;
    }

    public int xS() {
        return this.arn;
    }

    public int xT() {
        return this.aro;
    }

    public boolean isAvailable() {
        return this.aca != null && this.arn > 0 && this.aro > 0;
    }
}
