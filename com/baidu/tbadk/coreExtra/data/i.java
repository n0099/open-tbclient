package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class i {
    private final TbPageContext<?> ceu;
    private final int ctY;
    private final int ctZ;

    public TbPageContext<?> apb() {
        return this.ceu;
    }

    public int apc() {
        return this.ctY;
    }

    public int apd() {
        return this.ctZ;
    }

    public boolean isAvailable() {
        return this.ceu != null && this.ctY > 0 && this.ctZ > 0;
    }
}
