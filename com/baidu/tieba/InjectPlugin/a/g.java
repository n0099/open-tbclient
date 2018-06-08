package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int bfF;
    protected b bfG;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.bfF = i;
    }

    public g(b bVar, int i) {
        this.bfG = bVar;
        this.bfF = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b Op() {
        return this.bfG;
    }

    public int Oq() {
        return this.bfF;
    }
}
