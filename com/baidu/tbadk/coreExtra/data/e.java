package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class e {
    private final TbPageContext<?> aby;
    private final int aru;
    private final int arv;
    private final boolean arw;

    public e(TbPageContext<?> tbPageContext, int i, int i2, boolean z) {
        this.aby = tbPageContext;
        this.aru = i;
        this.arv = i2;
        this.arw = z;
    }

    public e(TbPageContext<?> tbPageContext, int i, int i2) {
        this(tbPageContext, i, i2, false);
    }

    public TbPageContext<?> yi() {
        return this.aby;
    }

    public int yj() {
        return this.aru;
    }

    public int yk() {
        return this.arv;
    }

    public boolean isAvailable() {
        return this.aby != null && this.aru > 0 && this.arv > 0;
    }
}
