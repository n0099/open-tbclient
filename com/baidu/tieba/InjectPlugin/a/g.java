package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int daP;
    protected b daQ;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.daP = i;
    }

    public g(b bVar, int i) {
        this.daQ = bVar;
        this.daP = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b aBc() {
        return this.daQ;
    }

    public int aBd() {
        return this.daP;
    }
}
