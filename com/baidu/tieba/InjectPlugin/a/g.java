package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int dSZ;
    protected b dTa;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.dSZ = i;
    }

    public g(b bVar, int i) {
        this.dTa = bVar;
        this.dSZ = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b aVD() {
        return this.dTa;
    }

    public int aVE() {
        return this.dSZ;
    }
}
