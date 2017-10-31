package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int aUl;
    protected b aUm;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.aUl = i;
    }

    public g(b bVar, int i) {
        this.aUm = bVar;
        this.aUl = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b JS() {
        return this.aUm;
    }

    public int JT() {
        return this.aUl;
    }
}
