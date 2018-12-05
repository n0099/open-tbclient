package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int bvE;
    protected b bvF;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.bvE = i;
    }

    public g(b bVar, int i) {
        this.bvF = bVar;
        this.bvE = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b TQ() {
        return this.bvF;
    }

    public int TR() {
        return this.bvE;
    }
}
