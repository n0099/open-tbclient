package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int bNJ;
    protected b bNK;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.bNJ = i;
    }

    public g(b bVar, int i) {
        this.bNK = bVar;
        this.bNJ = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b Su() {
        return this.bNK;
    }

    public int Sv() {
        return this.bNJ;
    }
}
