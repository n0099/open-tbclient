package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class j {
    private final TbPageContext<?> cVg;
    private final int chG;
    private final int chH;

    public TbPageContext<?> aJo() {
        return this.cVg;
    }

    public int aku() {
        return this.chH;
    }

    public int akt() {
        return this.chG;
    }

    public boolean isAvailable() {
        return this.cVg != null && this.chH > 0 && this.chG > 0;
    }
}
