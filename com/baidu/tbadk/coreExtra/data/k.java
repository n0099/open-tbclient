package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class k {
    private final TbPageContext<?> eXu;
    private final int eby;
    private final int ebz;

    public TbPageContext<?> bzM() {
        return this.eXu;
    }

    public int aVJ() {
        return this.ebz;
    }

    public int aVI() {
        return this.eby;
    }

    public boolean isAvailable() {
        return this.eXu != null && this.ebz > 0 && this.eby > 0;
    }
}
