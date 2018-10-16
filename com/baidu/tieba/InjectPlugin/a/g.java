package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int brt;
    protected b bru;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.brt = i;
    }

    public g(b bVar, int i) {
        this.bru = bVar;
        this.brt = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b SB() {
        return this.bru;
    }

    public int SC() {
        return this.brt;
    }
}
