package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class k {
    private final TbPageContext<?> eWx;
    private final int eau;
    private final int eav;

    public TbPageContext<?> bwp() {
        return this.eWx;
    }

    public int getAdHeight() {
        return this.eav;
    }

    public int getAdWidth() {
        return this.eau;
    }

    public boolean isAvailable() {
        return this.eWx != null && this.eav > 0 && this.eau > 0;
    }
}
