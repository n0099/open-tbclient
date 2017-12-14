package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int aXw;
    protected b aXx;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.aXw = i;
    }

    public g(b bVar, int i) {
        this.aXx = bVar;
        this.aXw = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b KB() {
        return this.aXx;
    }

    public int KC() {
        return this.aXw;
    }
}
