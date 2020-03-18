package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class j {
    private final TbPageContext<?> cVv;
    private final int chT;
    private final int chU;

    public TbPageContext<?> aJv() {
        return this.cVv;
    }

    public int akz() {
        return this.chU;
    }

    public int aky() {
        return this.chT;
    }

    public boolean isAvailable() {
        return this.cVv != null && this.chU > 0 && this.chT > 0;
    }
}
