package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int bNw;
    protected b bNx;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.bNw = i;
    }

    public g(b bVar, int i) {
        this.bNx = bVar;
        this.bNw = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b St() {
        return this.bNx;
    }

    public int Su() {
        return this.bNw;
    }
}
