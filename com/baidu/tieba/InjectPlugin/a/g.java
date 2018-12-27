package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int bvH;
    protected b bvI;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.bvH = i;
    }

    public g(b bVar, int i) {
        this.bvI = bVar;
        this.bvH = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b TS() {
        return this.bvI;
    }

    public int TT() {
        return this.bvH;
    }
}
