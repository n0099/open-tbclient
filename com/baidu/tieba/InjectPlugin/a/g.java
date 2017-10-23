package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int aUg;
    protected b aUh;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.aUg = i;
    }

    public g(b bVar, int i) {
        this.aUh = bVar;
        this.aUg = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b JI() {
        return this.aUh;
    }

    public int JJ() {
        return this.aUg;
    }
}
