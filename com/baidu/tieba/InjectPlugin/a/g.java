package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected b aSA;
    protected int aSz;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.aSz = i;
    }

    public g(b bVar, int i) {
        this.aSA = bVar;
        this.aSz = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b Jq() {
        return this.aSA;
    }

    public int Jr() {
        return this.aSz;
    }
}
