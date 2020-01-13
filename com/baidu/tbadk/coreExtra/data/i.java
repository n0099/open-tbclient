package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class i {
    private final TbPageContext<?> cRe;
    private final int cdD;
    private final int cdE;

    public TbPageContext<?> aGW() {
        return this.cRe;
    }

    public int aig() {
        return this.cdE;
    }

    public int aif() {
        return this.cdD;
    }

    public boolean isAvailable() {
        return this.cRe != null && this.cdE > 0 && this.cdD > 0;
    }
}
