package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class j {
    private final TbPageContext<?> cVi;
    private final int chI;
    private final int chJ;

    public TbPageContext<?> aJr() {
        return this.cVi;
    }

    public int akw() {
        return this.chJ;
    }

    public int akv() {
        return this.chI;
    }

    public boolean isAvailable() {
        return this.cVi != null && this.chJ > 0 && this.chI > 0;
    }
}
