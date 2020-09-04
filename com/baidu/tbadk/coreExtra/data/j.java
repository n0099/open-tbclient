package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class j {
    private final int dkP;
    private final int dkQ;
    private final TbPageContext<?> efr;

    public TbPageContext<?> bmF() {
        return this.efr;
    }

    public int aJe() {
        return this.dkQ;
    }

    public int aJd() {
        return this.dkP;
    }

    public boolean isAvailable() {
        return this.efr != null && this.dkQ > 0 && this.dkP > 0;
    }
}
