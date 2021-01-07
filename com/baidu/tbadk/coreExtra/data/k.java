package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class k {
    private final TbPageContext<?> eXu;
    private final int eby;
    private final int ebz;

    public TbPageContext<?> bzN() {
        return this.eXu;
    }

    public int aVK() {
        return this.ebz;
    }

    public int aVJ() {
        return this.eby;
    }

    public boolean isAvailable() {
        return this.eXu != null && this.ebz > 0 && this.eby > 0;
    }
}
