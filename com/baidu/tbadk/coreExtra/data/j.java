package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class j {
    private final int cGV;
    private final int cGW;
    private final TbPageContext<?> duK;

    public TbPageContext<?> aRP() {
        return this.duK;
    }

    public int asK() {
        return this.cGW;
    }

    public int asJ() {
        return this.cGV;
    }

    public boolean isAvailable() {
        return this.duK != null && this.cGW > 0 && this.cGV > 0;
    }
}
