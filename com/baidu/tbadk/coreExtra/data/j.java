package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes2.dex */
public class j {
    private final int dkL;
    private final int dkM;
    private final TbPageContext<?> efn;

    public TbPageContext<?> bmF() {
        return this.efn;
    }

    public int aJe() {
        return this.dkM;
    }

    public int aJd() {
        return this.dkL;
    }

    public boolean isAvailable() {
        return this.efn != null && this.dkM > 0 && this.dkL > 0;
    }
}
