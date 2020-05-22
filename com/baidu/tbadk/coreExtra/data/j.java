package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class j {
    private final int cRf;
    private final int cRg;
    private final TbPageContext<?> dIF;

    public TbPageContext<?> aXW() {
        return this.dIF;
    }

    public int awr() {
        return this.cRg;
    }

    public int awq() {
        return this.cRf;
    }

    public boolean isAvailable() {
        return this.dIF != null && this.cRg > 0 && this.cRf > 0;
    }
}
