package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class i {
    private final TbPageContext<?> cfl;
    private final int cuQ;
    private final int cuR;

    public TbPageContext<?> apd() {
        return this.cfl;
    }

    public int ape() {
        return this.cuQ;
    }

    public int apf() {
        return this.cuR;
    }

    public boolean isAvailable() {
        return this.cfl != null && this.cuQ > 0 && this.cuR > 0;
    }
}
