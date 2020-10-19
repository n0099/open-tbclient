package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class k {
    private final int dyX;
    private final int dyY;
    private final TbPageContext<?> etO;

    public TbPageContext<?> bqj() {
        return this.etO;
    }

    public int aMy() {
        return this.dyY;
    }

    public int aMx() {
        return this.dyX;
    }

    public boolean isAvailable() {
        return this.etO != null && this.dyY > 0 && this.dyX > 0;
    }
}
