package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class k {
    private final int dLE;
    private final int dLF;
    private final TbPageContext<?> eGu;

    public TbPageContext<?> btS() {
        return this.eGu;
    }

    public int aQk() {
        return this.dLF;
    }

    public int aQj() {
        return this.dLE;
    }

    public boolean isAvailable() {
        return this.eGu != null && this.dLF > 0 && this.dLE > 0;
    }
}
