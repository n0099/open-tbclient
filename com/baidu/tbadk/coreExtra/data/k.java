package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class k {
    private final int dYS;
    private final int dYT;
    private final TbPageContext<?> eUY;

    public TbPageContext<?> bwm() {
        return this.eUY;
    }

    public int getAdHeight() {
        return this.dYT;
    }

    public int getAdWidth() {
        return this.dYS;
    }

    public boolean isAvailable() {
        return this.eUY != null && this.dYT > 0 && this.dYS > 0;
    }
}
