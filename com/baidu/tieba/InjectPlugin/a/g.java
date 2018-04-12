package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int aXx;
    protected b aXy;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.aXx = i;
    }

    public g(b bVar, int i) {
        this.aXy = bVar;
        this.aXx = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b KS() {
        return this.aXy;
    }

    public int KT() {
        return this.aXx;
    }
}
