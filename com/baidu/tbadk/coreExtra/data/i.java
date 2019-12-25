package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class i {
    private final TbPageContext<?> cQU;
    private final int cdq;
    private final int cdr;

    public TbPageContext<?> aGD() {
        return this.cQU;
    }

    public int ahN() {
        return this.cdr;
    }

    public int ahM() {
        return this.cdq;
    }

    public boolean isAvailable() {
        return this.cQU != null && this.cdr > 0 && this.cdq > 0;
    }
}
