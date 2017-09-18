package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class e {
    private final TbPageContext<?> aby;
    private final int arr;
    private final int ars;
    private final boolean art;

    public e(TbPageContext<?> tbPageContext, int i, int i2, boolean z) {
        this.aby = tbPageContext;
        this.arr = i;
        this.ars = i2;
        this.art = z;
    }

    public e(TbPageContext<?> tbPageContext, int i, int i2) {
        this(tbPageContext, i, i2, false);
    }

    public TbPageContext<?> yi() {
        return this.aby;
    }

    public int yj() {
        return this.arr;
    }

    public int yk() {
        return this.ars;
    }

    public boolean isAvailable() {
        return this.aby != null && this.arr > 0 && this.ars > 0;
    }
}
