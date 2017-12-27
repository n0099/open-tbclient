package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int bLp;
    protected b bLq;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.bLp = i;
    }

    public g(b bVar, int i) {
        this.bLq = bVar;
        this.bLp = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b Sa() {
        return this.bLq;
    }

    public int Sb() {
        return this.bLp;
    }
}
