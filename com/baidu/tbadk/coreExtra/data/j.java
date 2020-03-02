package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class j {
    private final TbPageContext<?> cVh;
    private final int chH;
    private final int chI;

    public TbPageContext<?> aJq() {
        return this.cVh;
    }

    public int akw() {
        return this.chI;
    }

    public int akv() {
        return this.chH;
    }

    public boolean isAvailable() {
        return this.cVh != null && this.chI > 0 && this.chH > 0;
    }
}
