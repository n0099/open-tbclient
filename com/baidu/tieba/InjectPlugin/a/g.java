package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int aXA;
    protected b aXB;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.aXA = i;
    }

    public g(b bVar, int i) {
        this.aXB = bVar;
        this.aXA = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b KB() {
        return this.aXB;
    }

    public int KC() {
        return this.aXA;
    }
}
