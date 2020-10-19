package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int fzA;
    protected b fzB;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.fzA = i;
    }

    public g(b bVar, int i) {
        this.fzB = bVar;
        this.fzA = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b bDr() {
        return this.fzB;
    }

    public int bDs() {
        return this.fzA;
    }
}
