package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int dTm;
    protected b dTn;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.dTm = i;
    }

    public g(b bVar, int i) {
        this.dTn = bVar;
        this.dTm = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b aVE() {
        return this.dTn;
    }

    public int aVF() {
        return this.dTm;
    }
}
